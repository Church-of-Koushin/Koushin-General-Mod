package jp.koushin_lawfirm.www.entity;

import net.minecraft.client.renderer.entity.RenderTNTPrimed;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.util.ResourceLocation;

public class RenderNukePrimed extends RenderTNTPrimed {
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return new ResourceLocation("koushingeneralmod:entities/nukeprimed.png");
	}

}
