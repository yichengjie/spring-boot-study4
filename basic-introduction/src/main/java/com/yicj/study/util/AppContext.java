package com.yicj.study.util;

public class AppContext {
    private static ThreadLocal<AppContext> threadLocal = new ThreadLocal<>() ;
    private String userName ;

    private static AppContext getInstance(){
        AppContext appContext = threadLocal.get();
        if (appContext == null){
            appContext = new AppContext() ;
            threadLocal.set(appContext);
        }
        return appContext ;
    }

    public static void setUserName(String userName){
        AppContext instance = getInstance();
        instance.userName = userName ;
    }

    public static String getUserName(){
        AppContext instance = getInstance();
        return instance.userName ;
    }

    public static void clear(){
        threadLocal.remove(); ;
    }
}
