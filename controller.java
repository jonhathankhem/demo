package com.kj.logger;

public class controller {
 public static void setRefno(String refno) {
	 controller.refno = refno;
	}

	public static  void setSchema(String schema) {
		controller.schema = schema;
	}

	public static void setEnv(String env) {
		controller.env = env;
	}

public static String log_type=null,refno=null,schema=null,env=null,log_subtype=null,logpay=null,log_payload1=null;

/**
 * @return the log_type
 */
public static String getLog_type() {
	return log_type;
}

/**
 * @param log_type the log_type to set
 */
public static void setLog_type(String log_type) {
	controller.log_type = log_type;
}

/**
 * @return the log_subtype
 */
public static String getLog_subtype() {
	return log_subtype;
}

/**
 * @param log_subtype the log_subtype to set
 */
public static void setLog_subtype(String log_subtype) {
	controller.log_subtype = log_subtype;
}

/**
 * @return the log_payload
 */
public static String getLog_pay() {
	return logpay;
}

/**
 * @param log_payload the log_payload to set
 */
public static void setLog_pay(String log_payload) {
	logpay = log_payload;
}

/**
 * @return the log_payload1
 */
public static String getLog_payload1() {
	return log_payload1;
}

/**
 * @param log_payload1 the log_payload1 to set
 */
public static void setLog_payload1(String log_payload1) {
	controller.log_payload1 = log_payload1;
}

public static String getRefno() {
	return refno;
}

public static String getSchema() {
	return schema;
}

public  String getEnv() {
	return env;
}
}
