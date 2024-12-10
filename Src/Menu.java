public void onMsg(Object msg) {
    String text = msg.MessageContent;
    String qq = msg.UserUin;
    String qun = msg.GroupUin;

    if (text.equals("#KON") && qq.equals(MyUin)) {

        String reply = "====轻音部の小窝====" +
                "\n---------\n" +
                "请发送关键词" +
                "\n---------\n" +
                " - 轻音壁纸 - " +
                "\n"+
                " - 轻音表情包 - " +
                "\n---------\n" +
                "作者：B站@Tomoriゞ";

        if (msg.IsGroup)
        {
            sendMsg(qun,"",reply);
        }
        else
        {
            sendMsg("",qq,reply);
        }
    }
}