package tfar.unifiedstamina.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.common.data.LanguageProvider;
import tfar.unifiedstamina.USAttributes;
import tfar.unifiedstamina.UnifiedStamina;

public class USLangProvider extends LanguageProvider {
    public USLangProvider(PackOutput output) {
        super(output, UnifiedStamina.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addAttribute(USAttributes.STRENGTH, "Strength");
    }

    void addAttribute(Attribute attribute, String key) {
        add(attribute.getDescriptionId(),key);
    }
}
