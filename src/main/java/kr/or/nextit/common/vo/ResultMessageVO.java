package kr.or.nextit.common.vo;

public class ResultMessageVO {

	private boolean result;
	private String title;
	private String message;
	private String url;
	private String subUrl;
	
	public void failSetting(boolean result, String title, String message) {
		this.result = result;
		this.title = title;
		this.message = message;
	}

	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSubUrl() {
		return subUrl;
	}
	public void setSubUrl(String subUrl) {
		this.subUrl = subUrl;
	}
	@Override
	public String toString() {
		return "ResultMessageVO [result=" + result + ", title=" + title + ", message=" + message + ", url=" + url
				+ ", subUrl=" + subUrl + "]";
	}

	
	
}
