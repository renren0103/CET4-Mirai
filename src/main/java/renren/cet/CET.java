package renren.cet;

import net.mamoe.mirai.contact.Contact;
import net.mamoe.mirai.message.data.MessageChain;
import net.mamoe.mirai.message.data.MessageChainBuilder;
import net.mamoe.mirai.message.data.MusicKind;
import net.mamoe.mirai.message.data.MusicShare;
import net.mamoe.mirai.utils.ExternalResource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class CET {
    private final int count;
    private final ArrayList<String> mp3list = new ArrayList<>();

    public CET() {
        mp3list.add("/group85/M0B/D7/10/wKg5H18icMrB_sH2ALlyvXP0fIk629.m4a");//2015 12 1
        mp3list.add("/group85/M09/CD/6F/wKg5H18hdSigmZ-hALtzOQSvoGQ765.m4a");//2016 6 1
        mp3list.add("/group84/M0A/D4/BA/wKg5JF8iOU_CwYUDALcUR4bX0UM588.m4a");//2016 6 3
        mp3list.add("/group85/M0B/CD/CD/wKg5JV8hehXA17ZWALtYyaZ20nw130.m4a");//2016 6 2
        mp3list.add("/group85/M06/CA/7A/wKg5JV8hURmiKK7GAKkPavHeIt4318.m4a");//2016 12 1
        mp3list.add("/storages/2f07-audiofreehighqps/7D/D7/CMCoOSYDKlpTAKHeAQBSFayt.m4a");//2016 12 3
        mp3list.add("/group82/M04/CA/72/wKg5HF8hb8_QZVDnAKkj-zsBAHc198.m4a");//2016 12 2
        mp3list.add("/group86/M06/CA/7E/wKg5IF8hSk6xgWrXAKy1WOV4YQY436.m4a");//2017 6 1
        mp3list.add("/group85/M02/CA/55/wKg5JV8hTh2BQc4bALcFmKegTxE235.m4a");//2017 6 2
        mp3list.add("/group86/M05/CA/1C/wKg5Jl8hRLHyPAFWAK8eFv6c_3M969.m4a");//2017 12 1
        mp3list.add("/group85/M07/CA/2B/wKg5H18hR5PwTfXXAK28MsKL_x0423.m4a");//2017 12 2
        mp3list.add("/group86/M08/AC/81/wKg5Jl8eqeywWbmvAK-Kv90zIJI018.m4a");//2018 6 1
        mp3list.add("/group86/M01/AC/95/wKg5IF8eqfChtAlZALEi-WRHKA0734.m4a");// 2018 6 2
        mp3list.add("/group86/M01/AC/90/wKg5IF8eqdqBOQdqAK0k9Dq4KnQ853.m4a");//2018 12 1
        mp3list.add("/group86/M08/AC/7E/wKg5Jl8eqd6TJQFmALBMl_8-i7Y988.m4a");//2018 12 2
        mp3list.add("/group86/M0B/AC/8B/wKg5IF8eqcuyYlmuAK3fb-htKtU590.m4a");//2019 6 1
        mp3list.add("/group82/M03/1D/D0/wKg5Il8pLy6DKcVeAK6v9i35D1Q027.m4a");//2019 6 2
        mp3list.add("/group86/M0B/AC/8B/wKg5IF8eqcyBPL9DALMiViM4gWs908.m4a");//2019 12 1
        mp3list.add("/group86/M08/AC/7A/wKg5Jl8eqdLi_mkUAK7vGuy2cXc282.m4a");//2019 12 2
        mp3list.add("/storages/ead4-audiofreehighqps/B9/28/CMCoOSMDInUOALiPIwBQUxSg.m4a");//2020 7
        mp3list.add("/storages/fa96-audiofreehighqps/DE/AA/CMCoOSIDt3p9AKwm5wBzxuTo.m4a");//2020 12 1
        mp3list.add("/storages/650d-audiofreehighqps/AA/56/CKwRIDoEMQI8AKps5gCWWVnV.m4a");//2020 12 2
        mp3list.add("/storages/6ac7-audiofreehighqps/DC/C7/CKwRIasEm5hLAKtiIQC5Birt.m4a");//2021 6 1
        mp3list.add("storages/e84d-audiofreehighqps/A5/55/CKwRIUEE0IkHALAEoQDMnBzk.m4a");//2021 6 2
        this.count = new Random().nextInt(mp3list.size());
    }

    private MessageChain randomCET4() {
        return new MessageChainBuilder().append(new MusicShare(MusicKind.NeteaseCloudMusic, "英语听力", "听力考试现在开始", "http://music.163.com/song/1338728297/?userid=324076307", "http://p2.music.126.net/y19E5SadGUmSR8SZxkrNtw==/109951163785855539.jpg", "https://fdfs.xmcdn.com//" + mp3list.get(count))).build();
    }

    public void getListen(Contact contact) {
        contact.sendMessage(randomCET4());
    }

    private MessageChain getPictures(File files,Contact contact) throws IOException {
        MessageChainBuilder messageChainBuilder = new MessageChainBuilder();
        File[] file = Objects.requireNonNull(files.listFiles())[count].listFiles();
        for (int i = 0; i < Objects.requireNonNull(file).length; i++) {
            ExternalResource er = ExternalResource.create(file[i]);
            messageChainBuilder = messageChainBuilder.append(contact.uploadImage(er));
            er.close();
        }
        return (messageChainBuilder.build());
    }
    public void getAnswer(Contact contact) throws IOException {
        contact.sendMessage(getPictures(new File("./plugins/CET4/Answer"),contact));
    }
    public void getProblem(Contact contact) throws IOException {
        contact.sendMessage(getPictures(new File("./plugins/CET4/Problem"),contact));
    }
}
