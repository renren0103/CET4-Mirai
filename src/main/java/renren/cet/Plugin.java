package renren.cet;

import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.events.MessageEvent;

import java.io.IOException;

public final class Plugin extends JavaPlugin {
    public static final Plugin INSTANCE = new Plugin();
    CET cet = null;

    private Plugin() {
        super(new JvmPluginDescriptionBuilder("renren.cet.plugin", "0.1").build());
    }

    @Override
    public void onEnable() {
        GlobalEventChannel.INSTANCE.subscribeAlways(MessageEvent.class, groupMessageEvent -> {
            if (groupMessageEvent.getMessage().contentToString().equals("来套4级听力")) {
                cet = new CET();
                cet.getListen(groupMessageEvent.getSubject());
                groupMessageEvent.getSubject().sendMessage("输入来份试题以获取题目");
            }
            if (groupMessageEvent.getMessage().contentToString().equals("来份试题")) {
                if (cet == null) {
                    cet = new CET();
                    cet.getListen(groupMessageEvent.getSubject());
                } else {
                    try {
                        cet.getProblem(groupMessageEvent.getSender());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (groupMessageEvent.getMessage().contentToString().equals("来份答案")) {
                if (cet == null) {
                    cet = new CET();
                    cet.getListen(groupMessageEvent.getSubject());
                } else {
                    try {
                        cet.getAnswer(groupMessageEvent.getSender());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
    }
}