package jp.koushin_lawfirm.www.core;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = KoushinCore.MODID, version = KoushinCore.VERSION)
public class KoushinCore {
	// MODの初期設定
	public static final String MODID = "Koushin General Mod";
	public static final String VERSION = "0.1 Tsukushi-sonshi";
	@SidedProxy(clientSide = "jp.koushin_lawfirm.www.core.ClientProxy", serverSide = "jp.koushin_lawfirm.www.core.ServerProxy")
	public static CommonProxy proxy;

	// Items&Blocks
	private static Item6Char item6Char;

	// 以下init類
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);

		item6Char = new Item6Char();
		GameRegistry.registerItem(item6Char, "6Char");
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		EntityRegistry.registerModEntity(EntityLawyer.class, "Lawyer", 200,
				this, 80, 1, true);
		EntityRegistry.registerModEntity(Entity6Char.class, "6char", 201, this,
				128, 5, true);

		GameRegistry.addShapelessRecipe(new ItemStack(item6Char),
				Items.cooked_chicken,// 唐揚げ
				Items.fish,// 沢蟹
				Items.baked_potato,// コロッケ
				Items.cooked_porkchop// 酢豚
				);
		proxy.init(event);

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);

	}

}
