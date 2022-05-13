package ninety.megacells.integration.appmek;

import java.util.List;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;

import me.ramidzkh.mekae2.AMMenus;
import me.ramidzkh.mekae2.ae2.MekanismKeyType;
import ninety.megacells.item.MEGAItems;
import ninety.megacells.item.util.IMEGACellType;

import appeng.api.stacks.AEKeyType;
import appeng.menu.me.common.MEStorageMenu;

public enum ChemicalCellType implements IMEGACellType {
    TYPE;

    @Override
    public AEKeyType keyType() {
        return AppMekIntegration.isAppMekLoaded() ? MekanismKeyType.TYPE : AEKeyType.fluids();
    }

    @Override
    public String affix() {
        return "chemical";
    }

    @Override
    public Item housing() {
        return MEGAItems.MEGA_CHEMICAL_CELL_HOUSING.get();
    }

    @Override
    public TagKey<Item> housingMaterial() {
        return ItemTags.create(new ResourceLocation("forge", "ingots/osmium"));
    }

    @Override
    public MenuType<MEStorageMenu> portableCellMenu() {
        return AppMekIntegration.isAppMekLoaded()
                ? AMMenus.PORTABLE_CHEMICAL_CELL_TYPE
                : MEStorageMenu.PORTABLE_FLUID_CELL_TYPE;
    }

    @Override
    public List<Item> getCells() {
        return List.of(MEGAItems.CHEMICAL_CELL_1M.get(), MEGAItems.CHEMICAL_CELL_4M.get(),
                MEGAItems.CHEMICAL_CELL_16M.get(), MEGAItems.CHEMICAL_CELL_64M.get(),
                MEGAItems.CHEMICAL_CELL_256M.get());
    }

    @Override
    public List<Item> getPortableCells() {
        return List.of(MEGAItems.PORTABLE_CHEMICAL_CELL_1M.get(), MEGAItems.PORTABLE_CHEMICAL_CELL_4M.get(),
                MEGAItems.PORTABLE_CHEMICAL_CELL_16M.get(), MEGAItems.PORTABLE_CHEMICAL_CELL_64M.get(),
                MEGAItems.PORTABLE_CHEMICAL_CELL_256M.get());
    }
}
