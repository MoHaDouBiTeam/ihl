package ihl.nei_integration;

import java.awt.Rectangle;
import java.util.Map;

import ihl.processing.chemistry.LeadOvenGui;
import ihl.processing.chemistry.LeadOvenTileEntity;
import ihl.recipes.UniversalRecipeInput;
import ihl.recipes.UniversalRecipeOutput;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.StatCollector;

public class LeadOvenRecipeHandler extends MachineRecipeHandler {
	@Override
	public Class<? extends GuiContainer> getGuiClass() {
		return LeadOvenGui.class;
	}

	@Override
	protected int[] getInputPosX() {
		return new int[] { 47 - 5, 65 - 5 };
	}

	@Override
	protected int[] getInputPosY() {
		return new int[] { 17 - 11 };
	}

	@Override
	protected int[] getOutputPosX() {
		return new int[] { 112 - 5 };
	}

	@Override
	protected int[] getOutputPosY() {
		return new int[] { 35 - 11 };
	}

	@Override
	protected int[] getFluidOutputPosX() {
		return new int[] { 9 - 5 };
	}

	@Override
	protected int[] getFluidOutputPosY() {
		return new int[] { 53 - 11 };
	}

	@Override
	protected int[] getFluidInputPosX() {
		return new int[] { 9 - 5 };
	}

	@Override
	protected int[] getFluidInputPosY() {
		return new int[] { 17 - 11 };
	}

	@Override
	public String getRecipeId() {
		return "ihl.leadOven";
	}

	@Override
	public String getGuiTexture() {
		return "ihl:textures/gui/GUILeadOven.png";
	}

	@Override
	public String getOverlayIdentifier() {
		return "leadOven";
	}

	@Override
	public void loadTransferRects() {
		this.transferRects.add(
				new RecipeTransferRect(new Rectangle(80 - 10, 35 - 10, 22, 15), this.getRecipeId(), new Object[0]));
	}

	@Override
	public Map<UniversalRecipeInput, UniversalRecipeOutput> getRecipeList() {
		return LeadOvenTileEntity.getRecipes();
	}
}
