package ihl.interfaces;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class ItemMiniGUI 
{
	protected final GuiContainer guiBase;
	protected final Slot slotBase;
	
	public ItemMiniGUI(GuiContainer gui, Slot slot)
	{
		guiBase=gui;
		slotBase=slot;
	}
	
	public abstract void displayGUI();
	public abstract boolean handleMouseClick(int mouseButton, int mouseX, int mouseY);
    public abstract boolean handleKeyTyped(char characterTyped, int keyIndex);
	public abstract void onGUIClosed();
}