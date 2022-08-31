package com.thothconsumer;

  //NOTE: Transcribe request class is not needed to run program. You just need any object that can work as a means to store the 
        // POST data to then be converted into JSON. You can also just build the jason with the Keys and values directly
        // I used/created the TranscribeRequest class just for consistency and clarity with the API code / to explain

public class TranscribeRequest {
    private String jobName;
	private String mediaFileUri;
	private String outputBucket;
	private String region;
    private String doctorID;
    private String accessKeyId;
	private String secretAccessKey;

    public TranscribeRequest(){
        this.doctorID ="";
    }

    public String getJobName() {
        return jobName;
    }
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    public String getMediaFileUri() {
        return mediaFileUri;
    }
    public void setMediaFileUri(String mediaFileUri) {
        this.mediaFileUri = mediaFileUri;
    }
    public String getOutputBucket() {
        return outputBucket;
    }
    public void setOutputBucket(String outputBucket) {
        this.outputBucket = outputBucket;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getDoctorID() {
        return doctorID;
    }
    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    public void setSecretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
    }

    
}
