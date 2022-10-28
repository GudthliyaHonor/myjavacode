package com.dotk.core.domain;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;

public class BufferedServletInputStream extends ServletInputStream {

  private InputStream cachedBodyInputStream;

  public BufferedServletInputStream(InputStream cachedBodyInputStream) {
    this.cachedBodyInputStream = cachedBodyInputStream;
  }

  @Override
  public boolean isFinished() {
    try {
      return cachedBodyInputStream.available() == 0;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean isReady() {
    return true;
  }

  @Override
  public void setReadListener(ReadListener readListener) {

  }

  @Override
  public int read() throws IOException {
    return cachedBodyInputStream.read();
  }
}
