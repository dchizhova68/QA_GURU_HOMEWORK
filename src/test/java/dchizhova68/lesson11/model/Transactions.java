package dchizhova68.lesson11.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class Transactions {
    @JsonProperty("User id")
    private String userId;
    @JsonProperty("Transactions")
    private Integer transactionsCount;

    @JsonProperty("Cache count")
    private Integer cacheCount;

    public Integer getCacheCount() {
        return cacheCount;
    }

    public void setCacheCount(Integer cacheCount) {
        this.cacheCount = cacheCount;
    }

    private TransactionsInner [] transactions;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getTransactionsCount() {
        return transactionsCount;
    }

    public void setTransactionsCount(Integer transactionsCount) {
        this.transactionsCount = transactionsCount;
    }

    public TransactionsInner[] getTransactions() {
        return transactions;
    }

    public void setTransactions(TransactionsInner[] transactions) {
        this.transactions = transactions;
    }
}
