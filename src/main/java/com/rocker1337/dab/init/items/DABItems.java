package com.rocker1337.dab.init.items;

import com.rocker1337.dab.init.SoundEvents.RegisterSoundEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DABItems
{
    //Items
    public static Item jenna;
    public static Item weed;
    public static Item Derek;
    public static Item LAUSD;
    public static Item bobatea;
    public static Item LessFlight;
    public static Item GreatFlight;
    public static Item EnderFlight;
    public static Item Hammer;
    public static Item AirHorn;
    public static Item mlgcancan;
    public static Item SadAirHorn;
    public static Item thoriumpickaxe;
    public static Item thoriumsword;
    public static Item thoriumaxe;
    public static Item thoriumshovel;
    public static Item multitool;
    public static Item thoriumhelmet;
    public static Item thoriumchestplate;
    public static Item thoriumleggings;
    public static Item thoriumboots;
    public static Item thorium_gem;

    //Tool Materials
    public static Item.ToolMaterial thoriummaterial = EnumHelper.addToolMaterial("thoriummaterial", 2147483647, -1, 2147483647.0F, 2147483647.0F, 2147483647);
    //Armor Materials
    public static ItemArmor.ArmorMaterial ThoriumArmor = EnumHelper.addArmorMaterial("ThoriumArmor", "dab:thorium", -1, new int[] {7, 7, 7, 7}, 2147483647, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2147483647.0F);

    public static void init()
    {
        jenna = new jenna();
        weed = new weed(1, 0.3F, true).setFull3D();
        Derek = new derek();
        LAUSD = new LAUSD().setFull3D();
        bobatea = new bobatea(20, 5.0F, true);
        LessFlight = new LessFlight();
        GreatFlight = new GreatFlight();
        EnderFlight = new EnderFlight();
        Hammer = new Hammer();
        AirHorn = new AirHorn();
        mlgcancan = new MLGCanCanDisk("mlgcancan", RegisterSoundEvents.records_mlgcancan);
        SadAirHorn = new SadAirHorn();
        thoriumpickaxe = new thoriumpickaxe(DABItems.thoriummaterial);
        thoriumaxe = new thoriumaxe(DABItems.thoriummaterial, 2147483647.0F, 2147483647.0F);
        thoriumsword = new thoriumsword(DABItems.thoriummaterial);
        thoriumshovel = new thoriumshovel(DABItems.thoriummaterial);
        multitool = new multitool(DABItems.thoriummaterial);
        thoriumhelmet = new ThoriumArmor(SetItemNames.DABItems.THORIUMHELMET.getUnlocalizedName(), SetItemNames.DABItems.THORIUMHELMET.getRegistryName(), DABItems.ThoriumArmor, 1, EntityEquipmentSlot.HEAD);
        thoriumchestplate = new ThoriumArmor(SetItemNames.DABItems.THORIUMCHESTPLATE.getUnlocalizedName(), SetItemNames.DABItems.THORIUMCHESTPLATE.getRegistryName(), DABItems.ThoriumArmor, 1, EntityEquipmentSlot.CHEST);
        thoriumleggings = new ThoriumArmor(SetItemNames.DABItems.THORIUMLEGS.getUnlocalizedName(), SetItemNames.DABItems.THORIUMLEGS.getRegistryName(), DABItems.ThoriumArmor, 2, EntityEquipmentSlot.LEGS);
        thoriumboots = new ThoriumArmor(SetItemNames.DABItems.THORIUMBOOTS.getUnlocalizedName(), SetItemNames.DABItems.THORIUMBOOTS.getRegistryName(), DABItems.ThoriumArmor, 1, EntityEquipmentSlot.FEET);
        thorium_gem = new ThoriumGem();
    }

    public static void register()
    {
        GameRegistry.register(jenna);
        GameRegistry.register(weed);
        GameRegistry.register(Derek);
        GameRegistry.register(LAUSD);
        GameRegistry.register(bobatea);
        GameRegistry.register(LessFlight);
        GameRegistry.register(GreatFlight);
        GameRegistry.register(EnderFlight);
        GameRegistry.register(Hammer);
        GameRegistry.register(AirHorn);
        GameRegistry.register(mlgcancan);
        GameRegistry.register(SadAirHorn);
        GameRegistry.register(thoriumpickaxe);
        GameRegistry.register(thoriumshovel);
        GameRegistry.register(thoriumaxe);
        GameRegistry.register(thoriumsword);
        GameRegistry.register(multitool);
        GameRegistry.register(thoriumhelmet);
        GameRegistry.register(thoriumchestplate);
        GameRegistry.register(thoriumleggings);
        GameRegistry.register(thoriumboots);
        GameRegistry.register(thorium_gem);

    }

    public static void registerRenders()
    {
        registerRender(weed);
        registerRender(jenna);
        registerRender(Derek);
        registerRender(LAUSD);
        registerRender(bobatea);
        registerRender(LessFlight);
        registerRender(GreatFlight);
        registerRender(EnderFlight);
        registerRender(Hammer);
        registerRender(AirHorn);
        registerRender(mlgcancan);
        registerRender(SadAirHorn);
        registerRender(thoriumpickaxe);
        registerRender(thoriumaxe);
        registerRender(thoriumsword);
        registerRender(thoriumshovel);
        registerRender(multitool);
        registerRender(thoriumhelmet);
        registerRender(thoriumchestplate);
        registerRender(thoriumleggings);
        registerRender(thoriumboots);
        registerRender(thorium_gem);
    }

    private static void  registerRender(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    public static void setCreativeTab()
    {
        weed.setCreativeTab(tabDAB);
        jenna.setCreativeTab(tabDAB);
        Derek.setCreativeTab(tabDAB);
        LAUSD.setCreativeTab(tabDAB);
        bobatea.setCreativeTab(tabDAB);
        LessFlight.setCreativeTab(tabDAB);
        GreatFlight.setCreativeTab(tabDAB);
        EnderFlight.setCreativeTab(tabDAB);
        Hammer.setCreativeTab(tabDAB);
        AirHorn.setCreativeTab(tabDAB);
        mlgcancan.setCreativeTab(tabDAB);
        SadAirHorn.setCreativeTab(tabDAB);
        thoriumpickaxe.setCreativeTab(tabDAB);
        thoriumshovel.setCreativeTab(tabDAB);
        thoriumaxe.setCreativeTab(tabDAB);
        thoriumsword.setCreativeTab(tabDAB);
        thoriumhelmet.setCreativeTab(tabDAB);
        thoriumboots.setCreativeTab(tabDAB);
        thoriumleggings.setCreativeTab(tabDAB);
        thoriumchestplate.setCreativeTab(tabDAB);
        thorium_gem.setCreativeTab(tabDAB);
    }

    public static final CreativeTabs tabDAB = new CreativeTabs("Development and Breean") {
        @Override
        public Item getTabIconItem()
        {
            return DABItems.weed;
        }
    };
}
