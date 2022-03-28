package net.inbackpackeat.client;

import me.shedaniel.architectury.event.events.TooltipEvent;
import net.inbackpackeat.utils.Utils;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.TextComponent;

public class ToolTips {
    public ToolTips() {
        TooltipEvent.ITEM.register((item, lines, flag) -> {
            if (Utils.isFood(item)) {
                lines.add(new TextComponent("[" + ModKeys.EAT.getTranslatedKeyMessage().getContents() + "] "
                        + I18n.get("tooltip.food.eat").trim()));
            }
        });
    }
}
