AddItem("轻音壁纸", "Wallpaper");
public void Wallpaper(String group) {
    if ("1".equals(getString(group, "是否开启壁纸"))) {
        putString(group, "是否开启壁纸", null);
        Toast("轻音壁纸关闭");
    } else {
        putString(group, "是否开启壁纸", "1");
        Toast("轻音壁纸开启");
    }
}
private boolean wallpaperNotified = false;

public void onMsg(Object msg) {
    String text = msg.MessageContent;
    String qq = msg.msg.peerUin + "";
    String qun = msg.GroupUin;
    String groupId = msg.GroupUin;
    String content = msg.MessageContent;

    boolean wallpaperEnabled = msg.IsGroup && "1".equals(getString(qun, "是否开启壁纸"));

    if (content.startsWith("轻音壁纸")) {
        if (wallpaperEnabled) {
            try {
                String apiUrl = getRandomApi();
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
                sendMsg(qun, "", "获取壁纸失败");
            }
        } else if (msg.IsGroup && !wallpaperNotified) {
            sendMsg(qun, "", "轻音壁纸未开启");
            wallpaperNotified = true; // 设置标志位为已通知
        }
    }
}

private String apiBaseUrl = "https://api.x-x.work/get/Wallpaper/KON";
private String getRandomApi() {
    Random random = new Random();
    int choice = random.nextInt(3); // 3个Api
    switch (choice) {
        case 0:
            return apiBaseUrl + "?PC"; 
        case 1:
            return apiBaseUrl + "?Mobile"; 
        case 2:
            return apiBaseUrl + "?Space"; 
        default:
            return apiBaseUrl + "?Space"; 
    }
}