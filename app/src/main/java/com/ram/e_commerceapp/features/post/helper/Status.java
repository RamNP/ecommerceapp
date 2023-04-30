package com.ram.e_commerceapp.features.post.helper;

public class Status{
	private String executionTime;
	private String requestTime;
	private String endpoint;
	private int code;
	private String apiVersion;
	private String functionsVersion;
	private String data;
	private String la;
	private String requestId;
	private int mu;
	private int pmu;

	public String getExecutionTime(){
		return executionTime;
	}

	public String getRequestTime(){
		return requestTime;
	}

	public String getEndpoint(){
		return endpoint;
	}

	public int getCode(){
		return code;
	}

	public String getApiVersion(){
		return apiVersion;
	}

	public String getFunctionsVersion(){
		return functionsVersion;
	}

	public String getData(){
		return data;
	}

	public String getLa(){
		return la;
	}

	public String getRequestId(){
		return requestId;
	}

	public int getMu(){
		return mu;
	}

	public int getPmu(){
		return pmu;
	}
}
