package com.desarrollo.votaciones.api.utilidades;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Alejo Gómez
 */
public class Comunes {
    public static String getClientIp(HttpServletRequest request) {

		String remoteAddr = "";
        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        return remoteAddr;
	}

}
