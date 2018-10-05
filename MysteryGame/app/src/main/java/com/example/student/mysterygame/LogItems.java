package com.example.student.mysterygame;

/**
 * Created by student on 09/05/2018.
 */

public class LogItems {

    //This is a Data set class. This is used to set, store and call a Data Set. in this case
    //The data set contains the logName, logDate and lodEntry.

    /**
     * There is no need to touch this class if you are not adding a data set. this can be ignored
     * for the most part.
     */

    private String logName;
    private String logDate;
    private String logEntry;

    public String getLogName(){return  logName;}
    public String getLogDate(){return logDate;}
    public String getLogEntry(){return logEntry;}

    public void setLogName(String LogName){this.logName = LogName;}
    public void setLogDate(String LogDate){this.logDate = LogDate;}
    public void setLogEntry(String logEntry){this.logEntry = logEntry;}

    public LogItems(String name, String date, String logEntry){

        this.logEntry = logEntry;
        this.logName = name;
        this.logDate = date;
    }
}
