package tfar.unifiedstamina.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.combatroll.client.CombatRollClient;
import net.combatroll.client.gui.Drawable;
import net.combatroll.client.gui.HudElement;
import net.combatroll.client.gui.HudKeyVisuals;
import net.combatroll.client.gui.HudRenderHelper;
import net.combatroll.config.ClientConfig;
import net.combatroll.config.HudConfig;
import net.combatroll.internals.RollManager;
import net.combatroll.internals.RollingEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.phys.Vec2;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Objects;

@Mixin(HudRenderHelper.class)
public class HudRenderHelperMixin {

    /**
     * @author
     * @reason
     */
    @Overwrite(remap = false)
    public static void render(GuiGraphics context, float tickDelta) {
        /*ClientConfig config = CombatRollClient.config;
        Minecraft client = Minecraft.getInstance();
        LocalPlayer player = client.player;
        HudRenderHelper.ViewModel viewModel;
        if (player == null) {
            viewModel = HudRenderHelper.ViewModel.mock();
        } else {
            if (player.isCreative() && !config.showHUDInCreative) {
                return;
            }

            if (player.isSpectator()) {
                return;
            }

            RollingEntity rollingPlayer = (RollingEntity)player;
            RollManager.CooldownInfo cooldownInfo = rollingPlayer.getRollManager().getCooldown();
            if (!config.showWhenFull && cooldownInfo.availableRolls() == cooldownInfo.maxRolls()) {
                return;
            }

            viewModel = HudRenderHelper.ViewModel.create(cooldownInfo, tickDelta);
        }

        int screenWidth = client.getWindow().getGuiScaledWidth();
        int screenHeight = client.getWindow().getGuiScaledHeight();
        HudElement rollWidget = ((HudConfig)CombatRollClient.hudConfig.value).rollWidget;
        Vec2 originPoint = rollWidget.origin.getPoint(screenWidth, screenHeight);
        Vec2 drawOffset = rollWidget.offset;
        int horizontalSpacing = 8;
        int biggestTextureSize = 15;
        int var10000 = biggestTextureSize + horizontalSpacing * viewModel.elements.size();
        int drawX = (int)(originPoint.x + drawOffset.x);
        int drawY = (int)(originPoint.y + drawOffset.y - (float)(biggestTextureSize / 2));
        int drawnWith = 0;
        RenderSystem.enableBlend();

        for(HudRenderHelper.ViewModel.Element element : viewModel.elements()) {
            int x = 0;
            int y = 0;
            int u = 0;
            int v = 0;
            int width = 0;
            int height = 0;
            int textureSize = 0;
            x = drawX + drawnWith;
            u = 0;
            v = 0;
            textureSize = 15;
            height = 15;
            width = 15;
            context.setColor(1.0F, 1.0F, 1.0F, (float)config.hudBackgroundOpacity / 100.0F);
            context.blit(ARROW_BACKGROUND, x, drawY, (float)u, (float)v, width, height, textureSize, textureSize);
            int color = element.color;
            float red = (float)(color >> 16 & 255) / 255.0F;
            float green = (float)(color >> 8 & 255) / 255.0F;
            float blue = (float)(color & 255) / 255.0F;
            int prevTextureSize = textureSize;
            textureSize = 13;
            int shift = (prevTextureSize - textureSize) / 2;
            height = Math.round(element.full * (float)textureSize);
            x = drawX + drawnWith + shift;
            y = drawY + textureSize - height + shift;
            u = 0;
            v = textureSize - height;
            context.setColor(red, green, blue, element.full);
            context.blit(ARROW, x, y, (float)u, (float)v, textureSize, height, textureSize, textureSize);
            drawnWith += horizontalSpacing;
        }

        context.setColor(1.0F, 1.0F, 1.0F, 1.0F);
        if (config.showKeybinding) {
            Font textRenderer = client.gui.getFont();
            int keybindingX = drawX + drawnWith / 2;
            int keybindingY = drawY + 1;
            Drawable.Anchor iconHAnchor = Drawable.Anchor.CENTER;
            Drawable.Anchor iconVAnchor = Drawable.Anchor.TRAILING;
            switch (config.keybindingLabelPosition) {
                case LEFT:
                    keybindingX = drawX;
                    keybindingY = drawY + biggestTextureSize / 2;
                    iconHAnchor = Drawable.Anchor.TRAILING;
                    iconVAnchor = Drawable.Anchor.CENTER;
                case TOP:
                default:
                    if (viewModel.drawable != null) {
                        viewModel.drawable.draw(context, keybindingX, keybindingY, iconHAnchor, iconVAnchor);
                    } else if (viewModel.label != null) {
                        String label = viewModel.label;
                        int textLength = textRenderer.width(label);
                        int buttonLength = textLength + HudKeyVisuals.buttonLeading.draw().width() + HudKeyVisuals.buttonTrailing.draw().width();
                        if (iconHAnchor == Drawable.Anchor.TRAILING) {
                            keybindingX -= buttonLength / 2;
                        }

                        HudKeyVisuals.buttonLeading.draw(context, keybindingX - textLength / 2, keybindingY, Drawable.Anchor.TRAILING, iconVAnchor);
                        HudKeyVisuals.buttonCenter.drawFlexibleWidth(context, keybindingX - textLength / 2, keybindingY, textLength, iconVAnchor);
                        HudKeyVisuals.buttonTrailing.draw(context, keybindingX + textLength / 2, keybindingY, Drawable.Anchor.LEADING, iconVAnchor);
                        Objects.requireNonNull(textRenderer);
                        int textHeight = 9 + 1;
                        int textY = keybindingY;
                        switch (iconVAnchor) {
                            case LEADING -> textY = keybindingY;
                            case TRAILING -> textY = keybindingY - textHeight;
                            case CENTER -> textY = keybindingY - (textHeight / 2 - 1);
                        }

                        context.drawCenteredString(textRenderer, label, keybindingX, textY, 16777215);
                    }
            }
        }

        context.setColor(1.0F, 1.0F, 1.0F, 1.0F);*/
    }
}
