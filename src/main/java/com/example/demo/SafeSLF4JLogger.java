package com.example.demo;

import java.util.Arrays;

import org.owasp.esapi.ESAPI;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.MessageFormatter;

public class SafeSLF4JLogger implements Logger {

	private final Logger delegate;
	
	public SafeSLF4JLogger(Logger logger) {
		this.delegate = logger;
	}
	
	@Override
	public String getName() {
		return delegate.getName();
	}

	@Override
	public boolean isTraceEnabled() {
		return delegate.isTraceEnabled();
	}

	@Override
	public void trace(String msg) {
		delegate.trace(msg);
	}

	@Override
	public void trace(String format, Object arg) {
		if (delegate.isTraceEnabled()) {
			delegate.trace(format, sanitize(arg));
		}
	}

	@Override
	public void trace(String format, Object arg1, Object arg2) {
		if (delegate.isTraceEnabled()) {
			delegate.trace(format, sanitize(arg1), sanitize(arg2));
		}
	}

	@Override
	public void trace(String format, Object... arguments) {
		if (delegate.isTraceEnabled()) {
			delegate.trace(format, sanitize((Object[])arguments));
		}
	}

	@Override
	public void trace(String msg, Throwable t) {
		delegate.trace(msg, t);
	}

	@Override
	public boolean isTraceEnabled(Marker marker) {
		return delegate.isTraceEnabled(marker);
	}

	@Override
	public void trace(Marker marker, String msg) {
		delegate.trace(marker, msg);
	}

	@Override
	public void trace(Marker marker, String format, Object arg) {
		if (delegate.isTraceEnabled(marker)) {
			delegate.trace(marker, format,sanitize(arg));
		}
	}

	@Override
	public void trace(Marker marker, String format, Object arg1, Object arg2) {
		if (delegate.isTraceEnabled(marker)) {
			delegate.trace(marker, format, sanitize(arg1), sanitize(arg1));
		}
	}

	@Override
	public void trace(Marker marker, String format, Object... argArray) {
		if (delegate.isTraceEnabled(marker)) {
			delegate.trace(marker, format, sanitize((Object[])argArray));
		}
	}

	@Override
	public void trace(Marker marker, String msg, Throwable t) {
		delegate.trace(marker, msg, t);
		
	}

	@Override
	public boolean isDebugEnabled() {
		return delegate.isDebugEnabled();
	}

	@Override
	public void debug(String msg) {
		delegate.debug(msg);
	}

	@Override
	public void debug(String format, Object arg) {
		if (delegate.isDebugEnabled()) {
			delegate.debug(format, sanitize(arg));
		}
	}

	@Override
	public void debug(String format, Object arg1, Object arg2) {
		if (delegate.isDebugEnabled()) {
			delegate.debug(format, sanitize(arg1), sanitize(arg2));
		}
	}

	@Override
	public void debug(String format, Object... arguments) {
		if (delegate.isDebugEnabled()) {
			delegate.debug(format, sanitize((Object[])arguments));
		}
	}

	@Override
	public void debug(String msg, Throwable t) {
		delegate.debug(msg, t);
	}

	@Override
	public boolean isDebugEnabled(Marker marker) {
		return delegate.isDebugEnabled(marker);
	}

	@Override
	public void debug(Marker marker, String msg) {
		delegate.debug(marker, msg);
	}

	@Override
	public void debug(Marker marker, String format, Object arg) {
		if (delegate.isDebugEnabled(marker)) {
			delegate.debug(marker, format, sanitize(arg));
		}
	}

	@Override
	public void debug(Marker marker, String format, Object arg1, Object arg2) {
		if (delegate.isDebugEnabled(marker)) {
			delegate.debug(marker, format, sanitize(arg1), sanitize(arg2));
		}
	}

	@Override
	public void debug(Marker marker, String format, Object... arguments) {
		if (delegate.isDebugEnabled(marker)) {
			delegate.debug(marker, format, sanitize((Object[])arguments));
		}
	}

	@Override
	public void debug(Marker marker, String msg, Throwable t) {
		delegate.debug(marker, msg, t);
	}

	@Override
	public boolean isInfoEnabled() {
		return delegate.isInfoEnabled();
	}

	@Override
	public void info(String msg) {
		delegate.info(msg);
	}

	@Override
	public void info(String format, Object arg) {
		if (delegate.isInfoEnabled()) {
			delegate.info(format, sanitize(arg));
		}
	}

	@Override
	public void info(String format, Object arg1, Object arg2) {
		if (delegate.isInfoEnabled()) {
			delegate.info(format, sanitize(arg1), sanitize(arg2));
		}
	}

	@Override
	public void info(String format, Object... arguments) {
		if (delegate.isInfoEnabled()) {
			delegate.info(format, sanitize(arguments));
		}
	}

	@Override
	public void info(String msg, Throwable t) {
		delegate.info(msg, t);
	}

	@Override
	public boolean isInfoEnabled(Marker marker) {
		return delegate.isInfoEnabled(marker);
	}

	@Override
	public void info(Marker marker, String msg) {
		delegate.info(marker, msg);
		
	}

	@Override
	public void info(Marker marker, String format, Object arg) {
		if (delegate.isInfoEnabled(marker)) {
			delegate.info(marker, format, sanitize(arg));
		}
	}

	@Override
	public void info(Marker marker, String format, Object arg1, Object arg2) {
		if (delegate.isInfoEnabled(marker)) {
			delegate.info(marker, format, sanitize(arg1), sanitize(arg2));
		}
	}

	@Override
	public void info(Marker marker, String format, Object... arguments) {
		if (delegate.isInfoEnabled(marker)) {
			delegate.info(marker, format, sanitize(arguments));
		}
	}

	@Override
	public void info(Marker marker, String msg, Throwable t) {
		delegate.info(marker, msg, t);
	}

	@Override
	public boolean isWarnEnabled() {
		return delegate.isWarnEnabled();
	}

	@Override
	public void warn(String msg) {
		delegate.warn(msg);
	}

	@Override
	public void warn(String format, Object arg) {
		if (delegate.isWarnEnabled()) {
			delegate.warn(format, sanitize(arg));
		}
	}

	@Override
	public void warn(String format, Object arg1, Object arg2) {
		if (delegate.isWarnEnabled()) {
			delegate.warn(format, sanitize(arg1), sanitize(arg2));
		}
	}

	@Override
	public void warn(String format, Object... arguments) {
		if (delegate.isWarnEnabled()) {
			delegate.warn(format, sanitize(arguments));
		}
	}

	@Override
	public void warn(String msg, Throwable t) {
		delegate.warn(msg, t);
	}

	@Override
	public boolean isWarnEnabled(Marker marker) {
		return delegate.isWarnEnabled(marker);
	}

	@Override
	public void warn(Marker marker, String msg) {
		delegate.warn(marker, msg);
	}

	@Override
	public void warn(Marker marker, String format, Object arg) {
		if (delegate.isWarnEnabled(marker)) {
			delegate.warn(marker, format, sanitize(arg));
		}
	}

	@Override
	public void warn(Marker marker, String format, Object arg1, Object arg2) {
		if (delegate.isWarnEnabled(marker)) {
			delegate.warn(marker, format, sanitize(arg1), sanitize(arg2));
		}
	}

	@Override
	public void warn(Marker marker, String format, Object... arguments) {
		if (delegate.isWarnEnabled(marker)) {
			delegate.warn(marker, format, sanitize(arguments));
		}
	}

	@Override
	public void warn(Marker marker, String msg, Throwable t) {
		delegate.warn(marker, msg, t);
	}

	@Override
	public boolean isErrorEnabled() {
		return delegate.isErrorEnabled();
	}

	@Override
	public void error(String msg) {
		delegate.error(msg);
	}

	@Override
	public void error(String format, Object arg) {
		if(delegate.isErrorEnabled()) {
			delegate.error(format, sanitize(arg));
		}
	}

	@Override
	public void error(String format, Object arg1, Object arg2) {
		if(delegate.isErrorEnabled()) {
			delegate.error(format, sanitize(arg1), sanitize(arg2));
		}
	}

	@Override
	public void error(String format, Object... arguments) {
		if(delegate.isErrorEnabled()) {
			delegate.error(format, sanitize(arguments));
		}
	}

	@Override
	public void error(String msg, Throwable t) {
		delegate.error(msg, t);
	}

	@Override
	public boolean isErrorEnabled(Marker marker) {
		return delegate.isErrorEnabled(marker);
	}

	@Override
	public void error(Marker marker, String msg) {
		delegate.error(marker, msg);
	}

	@Override
	public void error(Marker marker, String format, Object arg) {
		if(delegate.isErrorEnabled(marker)) {
			delegate.error(marker, format, sanitize(arg));
		}
	}

	@Override
	public void error(Marker marker, String format, Object arg1, Object arg2) {
		if(delegate.isErrorEnabled(marker)) {
			delegate.error(marker, format, sanitize(arg1), sanitize(arg2));
		}
	}

	@Override
	public void error(Marker marker, String format, Object... arguments) {
		if(delegate.isErrorEnabled(marker)) {
			delegate.error(marker, format, sanitize(arguments));
		}
	}

	@Override
	public void error(Marker marker, String msg, Throwable t) {
		delegate.error(marker, msg, t);
	}
	
	public static final Object sanitize(Object arg) {
		if (arg == null) {
			return "null";
		}
		
        if (!arg.getClass().isArray()) {
            return sanitizeString(MessageFormatter.format("{}", arg).getMessage());
        } else {
        	Object[] safeArgs = sanitize((Object[])arg);
        	return safeArgs == null ? "null": safeArgs;
        }
	}

	public static final Object[] sanitize(Object[] args) {
		if (args == null) {
			return null;
		}
		
    	String[] strArgs = Arrays.stream(args)
    			.map(item -> sanitizeString(MessageFormatter.format("{}",  item).getMessage()))
    			.toArray(String[]::new);
    	
    	return strArgs;
	}

    private static final String sanitizeString(String message) {
    	if (message == null) {
    		return null;
    	}
    	
    	System.out.println(message);
    	String clean = message.replace('\n', '_').replace('\r', '_');
        
        clean = ESAPI.encoder().encodeForHTML(clean);
        if (!message.equals(clean)) {
            clean += " (Encoded)";
        }

        return clean;
    }
}
