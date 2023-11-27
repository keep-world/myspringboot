package com.test.compare.vo;


import java.util.Arrays;

public class PersistenceDataTask {
    private String[][] data;
    private String notifyTopic;
    private int sliceIndex;
    private int sliceSize;
    private String messageId;

    public PersistenceDataTask() {
    }

    public PersistenceDataTask(String[][] data, String notifyTopic, int sliceIndex, int sliceSize, String messageId) {
        this.data = data;
        this.notifyTopic = notifyTopic;
        this.sliceIndex = sliceIndex;
        this.sliceSize = sliceSize;
        this.messageId = messageId;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    public String getNotifyTopic() {
        return notifyTopic;
    }

    public void setNotifyTopic(String notifyTopic) {
        this.notifyTopic = notifyTopic;
    }

    public int getSliceIndex() {
        return sliceIndex;
    }

    public void setSliceIndex(int sliceIndex) {
        this.sliceIndex = sliceIndex;
    }

    public int getSliceSize() {
        return sliceSize;
    }

    public void setSliceSize(int sliceSize) {
        this.sliceSize = sliceSize;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "PersistenceDataTask{" +
                "data=" + Arrays.toString(data) +
                ", notifyTopic='" + notifyTopic + '\'' +
                ", sliceIndex=" + sliceIndex +
                ", sliceSize=" + sliceSize +
                ", messageId='" + messageId + '\'' +
                '}';
    }
}
