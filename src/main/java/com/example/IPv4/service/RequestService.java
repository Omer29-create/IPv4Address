package com.example.IPv4.service;

import javax.servlet.http.HttpServletRequest;

public interface RequestService {
    String getClientIPAddress(HttpServletRequest request);
}
