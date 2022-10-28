package com.dotk.core.domain;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 解决拦截器从流中获取完整的 body 请求参数后，无法再次调用流中数据的问题，否则报以下错误信息
 * <p>
 * I/O error while reading input message; nested exception is java.io.IOException: Stream closed
 */
public class RequestWrapper extends HttpServletRequestWrapper {
  private static final Logger LOGGER = LoggerFactory.getLogger(RequestWrapper.class);

  private final byte[] body;

  public RequestWrapper(HttpServletRequest request) throws IOException {
    super(request);
    body = inputStream2String(request.getInputStream()).getBytes(Charset.forName("UTF-8"));
  }

  @Override
  public BufferedReader getReader() throws IOException {
    return new BufferedReader(new InputStreamReader(getInputStream()));
  }

  @Override
  public ServletInputStream getInputStream() throws IOException {

    final ByteArrayInputStream bais = new ByteArrayInputStream(body);

    return new ServletInputStream() {

      @Override
      public int read() throws IOException {
        return bais.read();
      }

      @Override
      public boolean isFinished() {
        return false;
      }

      @Override
      public boolean isReady() {
        return false;
      }

      @Override
      public void setReadListener(ReadListener readListener) {

      }
    };
  }

  public String getPostBodyAsString() {
    if (null != body) {
      return new String(body);
    }
    return null;
  }

  /**
   * 将 inputStream 里的数据读取出来并转换成字符串
   *
   * @param inputStream inputStream
   * @return String
   */
  public String inputStream2String(InputStream inputStream) {
    StringBuilder sb = new StringBuilder();
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
      String line;
      while ((line = reader.readLine()) != null) {
        sb.append(line);
      }
    } catch (IOException e) {
      sb.append("get body params fail");
      LOGGER.error(e.getMessage());
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          LOGGER.error(e.getMessage());
        }
      }
    }
    return sb.toString();
  }
}