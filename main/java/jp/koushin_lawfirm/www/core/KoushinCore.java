package jp.koushin_lawfirm.www.core;

import jp.koushin_lawfirm.www.block.BlockTNTNuke;
import jp.koushin_lawfirm.www.entity.Entity6Char;
import jp.koushin_lawfirm.www.entity.EntityLawyer;
import jp.koushin_lawfirm.www.item.Item6Char;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
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
	private static BlockTNTNuke blockTNTNuke;

	// 以下init類
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		blockTNTNuke = new BlockTNTNuke();
		GameRegistry.registerBlock(blockTNTNuke, "Nuke");

		item6Char = new Item6Char();
		GameRegistry.registerItem(item6Char, "6Char");
		proxy.preInit(event);

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		// Dispenserによる射出
        BlockDispenser.dispenseBehaviorRegistry.putObject(Item.getItemFromBlock(blockTNTNuke), new BehaviorDefaultDispenseItem()
        {
            private static final String __OBFID = "CL_00001403";
            protected ItemStack dispenseStack(IBlockSource p_82487_1_, ItemStack p_82487_2_)
            {
                EnumFacing var3 = BlockDispenser.func_149937_b(p_82487_1_.getBlockMetadata());
                World var4 = p_82487_1_.getWorld();
                int var5 = p_82487_1_.getXInt() + var3.getFrontOffsetX();
                int var6 = p_82487_1_.getYInt() + var3.getFrontOffsetY();
                int var7 = p_82487_1_.getZInt() + var3.getFrontOffsetZ();
                EntityNukePrimed var8 = new EntityNukePrimed(var4, (double)((float)var5 + 0.5F), (double)((float)var6 + 0.5F), (double)((float)var7 + 0.5F),(EntityLivingBase)null);
                var4.spawnEntityInWorld(var8);
                --p_82487_2_.stackSize;
                return p_82487_2_;
            }
        });
		// 諸Entity
		EntityRegistry.registerModEntity(EntityLawyer.class, "Lawyer", 200,
				this, 80, 1, true);
		EntityRegistry.registerModEntity(Entity6Char.class, "6char", 201, this,
				128, 5, true);

		// 諸Recipe
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
