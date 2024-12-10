AddItem("轻音表情包", "Meme");

public void Meme(String group) {
    if (group != null && !group.isEmpty()) {
        putString(group, "是否开启表情包", "1");
        Toast("轻音表情包开启");
    }
}

private boolean memeNotified = false;

public void onMsg(Object msg) {
    String text = msg.MessageContent;
    String qq = msg.msg.peerUin + "";
    String qun = msg.GroupUin;
    String groupId = msg.GroupUin;
    String content = msg.MessageContent;

    boolean memeEnabled = msg.IsGroup && "1".equals(getString(qun, "是否开启表情包"));
    if (content.startsWith("轻音表情包")) {
        if (memeEnabled) {
            try {
                String apiUrl = "https://api.x-x.work/get/Wallpaper/KON?Meme";
                URL url = new URL(apiUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONArray jsonArray = new JSONArray(response.toString());
                Random random = new Random();
                int index = random.nextInt(jsonArray.length());
                JSONObject jsonObject = jsonArray.getJSONObject(index);
                String imageUrl = jsonObject.getString("Url");

                sendMsg(qun, "", "[PicUrl=" + imageUrl + "]");
            } catch (Exception e) {
                e.printStackTrace();
                sendMsg(qun, "", "获取表情包失败");
            }
        } else if (msg.IsGroup && !memeNotified) {
            sendMsg(qun, "", "轻音表情包未开启");
            memeNotified = true; // 设置标志位为已通知
        }
    } 
}