
String myUin=MyUin+"";
String pluginID=PluginID+"";
import android.app.Activity;
//Activity activity=GetActivity();

public void loadJava(String str){
load(str);
}

public void sendCard(String str,String str2,int type){
if(type==1)sendCard("",str,str2);else if(type==2)sendCard(str,"",str2);
}

public void sendMsg(String str,String str2,int type){
String str2=str2.replace("atUin=","AtQQ=").replace("pic=","PicUrl=");
if(type==1)sendMsg("",str,str2);else if(type==2)sendMsg(str,"",str2);
}

public void sendPtt(String str,String str2,int type){
if(type==1)sendVoice("",str,str2);else if(type==2)sendVoice(str,"",str2);
}
public void sendVideo(String str,String str2,int type){
if(type==1)sendVideo("",str,str2);else if(type==2)sendVideo(str,"",str2);
}
public void sendPic(String str,String str2,int type){
if(type==1)sendPic("",str,str2);else if(type==2)sendPic(str,"",str2);
}
public addItem(String str,String str2){
AddItem(str,str2);
}
public Activity getNowActivity(){
return GetActivity();
}

public void shutUp(String str,String str2,int i){
Forbidden(str,str2,i);
}

public void sendZan(String str,int i){
sendLike(str);
}

public void setGroupMemberTitle(String str,String str2,String str3){
setTitle(str,str2,str3);
}

public void kickGroup(String str,String str2,boolean z){
Kick(str,str2,z);
}


public void shutUpAll(String qun,boolean z){
if(z)Forbidden(qun,"",1);else Forbidden(qun,"",0);
}

public void shutUpAllFalse(String qun){
Forbidden(qun,"",2);
}

import com.tencent.mobileqq.troop.clockin.handler.TroopClockInHandler;
public void groupClockIn(String qun,String uin){
TroopClockInHandler inHandler;
try{
inHandler = new TroopClockInHandler(app);
}catch(e){
inHandler = new TroopClockInHandler();
}
Method method;
Class clazz = TroopClockInHandler.class;
Class[] ParamTYPE = new Class[]{String.class,String.class,int.class,boolean.class};
Method[] methods = clazz.getDeclaredMethods();
for (Method m : methods) {
    if (m.getParameterCount() == ParamTYPE.length ) {
        Class[] params = m.getParameterTypes();
        boolean match = true;
        for (int i = 0; i < ParamTYPE.length; i++) {
            if (!params[i].equals(ParamTYPE[i])) {
                match = false;
                break;
            }
        }
        if (match) {
            // 调用匹配的方法
            m.setAccessible(true);
            m.invoke(inHandler,new Object[]{qun,uin,0,true});
            break; // 找到匹配的方法后，跳出循环
        }
    }
}
}

String pluginPath=AppPath+"/";

public boolean isDoubleOpened(){
String path1=pluginPath.substring(18);
if(path1.startsWith("0")){
return false;
}else if(path1.startsWith("999")){
return true;
}
}
public String getLocalPath(){
return Environment.getExternalStorageDirectory().getPath()+"/";
}
