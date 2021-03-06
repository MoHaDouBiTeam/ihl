package ihl.model;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.Tessellator;
import net.minecraftforge.common.util.ForgeDirection;

@SideOnly(value=Side.CLIENT)
public class ModelTube {
	    /**
	     * The (x,y,z) vertex positions and (u,v) texture coordinates for each of the 8 points on a cube
	     */
	    private PositionTextureVertex[] vertexPositions;

	    /** An array of 6 TexturedQuads, one for each face of a cube */
	    private TexturedQuad[] quadList;

	    /** X vertex coordinate of lower box corner */
	    public final float posX1;

	    /** Y vertex coordinate of lower box corner */
	    public final float posY1;

	    /** Z vertex coordinate of lower box corner */
	    public final float posZ1;

	    /** X vertex coordinate of upper box corner */
	    public final float posX2;

	    /** Y vertex coordinate of upper box corner */
	    public final float posY2;

	    /** Z vertex coordinate of upper box corner */
	    public final float posZ2;
	    public String field_78247_g;
	    private ForgeDirection direction1;

		private int displayListCache=-1;

	    public ModelTube(IHLModelRenderer par1ModelRenderer, int par2, int par3, float x1, float y1, float z1, int par7, int par8, int par9, float par10, float radius1, float radius2, ForgeDirection direction1_1)
	    {
	    	this.direction1=direction1_1;
	        this.posX1 = x1;
	        this.posY1 = y1;
	        this.posZ1 = z1;
	        this.posX2 = x1 + par7;
	        this.posY2 = y1 + par8;
	        this.posZ2 = z1 + par9;
	        this.vertexPositions = new PositionTextureVertex[32];
	        this.quadList = new TexturedQuad[32];
	        float x2 = x1 + par7;
	        float y2 = y1 + par8;
	        float z2 = z1 + par9;
	        x1 -= par10;
	        y1 -= par10;
	        z1 -= par10;
	        x2 += par10;
	        y2 += par10;
	        z2 += par10;
	        float textureWidth = 16f;
	        float textureHeight = 16f;
	        if (par1ModelRenderer!=null)
	        {
	        	textureWidth = par1ModelRenderer.textureWidth;
	        	textureHeight = par1ModelRenderer.textureHeight;
	        	if(par1ModelRenderer.mirror)
	        	{
		            float var14 = x2;
		            x2 = x1;
		            x1 = var14;
	        	}
	        }
	        float dx = x2-x1 ;
	        float dy = y2-y1;
	        float dz = z2-z1;
	        PositionTextureVertex[] outervertexes1 = new PositionTextureVertex[8];
	        PositionTextureVertex[] innervertexes1 = new PositionTextureVertex[8];
	        PositionTextureVertex[] outervertexes2 = new PositionTextureVertex[8];
	        PositionTextureVertex[] innervertexes2 = new PositionTextureVertex[8];
	        int i=0;
	        for(i=0;i<8;i++)
	        {
	        	switch(direction1)
	        	{
	        		case UP:
	    	        	outervertexes1[i] = new PositionTextureVertex(x1+dx*0.5F+dx*0.5F*(float)Math.cos(2D*Math.PI/8D*i), y1, z1+dz*0.5F+dz*0.5F*(float)Math.sin(2D*Math.PI/8D*i), textureWidth, textureHeight);
	    	        	innervertexes1[i] = new PositionTextureVertex(x1+dx*0.5F+dx*radius1*0.5F*(float)Math.cos(2D*Math.PI/8D*i), y1, z1+dz*0.5F+dz*0.5F*radius1*(float)Math.sin(2D*Math.PI/8D*i), textureWidth, textureHeight);
	    	        	outervertexes2[i] = new PositionTextureVertex(x1+dx*0.5F+dx*0.5F*radius2*(float)Math.cos(2D*Math.PI/8D*i), y2, z1+dz*0.5F+dz*0.5F*radius2*(float)Math.sin(2D*Math.PI/8D*i), textureWidth, textureHeight);
	    	        	innervertexes2[i] = new PositionTextureVertex(x1+dx*0.5F+dx*radius1*radius2*0.5F*(float)Math.cos(2D*Math.PI/8D*i), y2, z1+dz*0.5F+dz*0.5F*radius2*radius1*(float)Math.sin(2D*Math.PI/8D*i), textureWidth, textureHeight);
	    	        	break;
	        		case DOWN:
	    	        	outervertexes1[i] = new PositionTextureVertex(x1+dx*0.5F+dx*0.5F*radius2*(float)Math.cos(2D*Math.PI/8D*i), y1, z1+dz*0.5F+dz*0.5F*radius2*(float)Math.sin(2D*Math.PI/8D*i), textureWidth, textureHeight);
	    	        	innervertexes1[i] = new PositionTextureVertex(x1+dx*0.5F+dx*radius1*radius2*0.5F*(float)Math.cos(2D*Math.PI/8D*i), y1, z1+dz*0.5F+dz*0.5F*radius1*radius2*(float)Math.sin(2D*Math.PI/8D*i), textureWidth, textureHeight);
	    	        	outervertexes2[i] = new PositionTextureVertex(x1+dx*0.5F+dx*0.5F*(float)Math.cos(2D*Math.PI/8D*i), y2, z1+dz*0.5F+dz*0.5F*(float)Math.sin(2D*Math.PI/8D*i), textureWidth, textureHeight);
	    	        	innervertexes2[i] = new PositionTextureVertex(x1+dx*0.5F+dx*radius1*0.5F*(float)Math.cos(2D*Math.PI/8D*i), y2, z1+dz*0.5F+dz*0.5F*radius1*(float)Math.sin(2D*Math.PI/8D*i), textureWidth, textureHeight);
	    	        	break;
	        		case SOUTH:
	    	        	outervertexes1[i] = new PositionTextureVertex(x1+dx*0.5F+dx*0.5F*(float)Math.cos(2D*Math.PI/8D*i), y1+dy*0.5F+dy*0.5F*(float)Math.sin(2D*Math.PI/8D*i), z2, textureWidth, textureHeight);
	    	        	innervertexes1[i] = new PositionTextureVertex(x1+dx*0.5F+dx*radius1*0.5F*(float)Math.cos(2D*Math.PI/8D*i), y1+dy*0.5F+dy*0.5F*radius1*(float)Math.sin(2D*Math.PI/8D*i), z2, textureWidth, textureHeight);
	    	        	outervertexes2[i] = new PositionTextureVertex(x1+dx*0.5F+dx*0.5F*radius2*(float)Math.cos(2D*Math.PI/8D*i), y1+dy*0.5F+dy*0.5F*radius2*(float)Math.sin(2D*Math.PI/8D*i), z1, textureWidth, textureHeight);
	    	        	innervertexes2[i] = new PositionTextureVertex(x1+dx*0.5F+dx*radius1*radius2*0.5F*(float)Math.cos(2D*Math.PI/8D*i), y1+dy*0.5F+dy*0.5F*radius1*radius2*(float)Math.sin(2D*Math.PI/8D*i), z1, textureWidth, textureHeight);
	    	        	break;
	        		case NORTH:
	    	        	outervertexes1[i] = new PositionTextureVertex(x1+dx*0.5F+dx*0.5F*radius2*(float)Math.cos(2D*Math.PI/8D*i), y1+dy*0.5F+dy*0.5F*radius2*(float)Math.sin(2D*Math.PI/8D*i), z2, textureWidth, textureHeight);
	    	        	innervertexes1[i] = new PositionTextureVertex(x1+dx*0.5F+dx*radius1*radius2*0.5F*(float)Math.cos(2D*Math.PI/8D*i), y1+dy*0.5F+dy*0.5F*radius1*radius2*(float)Math.sin(2D*Math.PI/8D*i), z2, textureWidth, textureHeight);
	    	        	outervertexes2[i] = new PositionTextureVertex(x1+dx*0.5F+dx*0.5F*(float)Math.cos(2D*Math.PI/8D*i), y1+dy*0.5F+dy*0.5F*(float)Math.sin(2D*Math.PI/8D*i), z1, textureWidth, textureHeight);
	    	        	innervertexes2[i] = new PositionTextureVertex(x1+dx*0.5F+dx*radius1*0.5F*(float)Math.cos(2D*Math.PI/8D*i), y1+dy*0.5F+dy*0.5F*radius1*(float)Math.sin(2D*Math.PI/8D*i), z1, textureWidth, textureHeight);
	    	        	break;
	        		case EAST:
	    	        	outervertexes1[i] = new PositionTextureVertex(x1, y1+dy*0.5F+dy*0.5F*(float)Math.sin(2D*Math.PI/8D*i), z1+dz*0.5F+dz*0.5F*(float)Math.cos(2D*Math.PI/8D*i), textureWidth, textureHeight);
	    	        	innervertexes1[i] = new PositionTextureVertex(x1, y1+dy*0.5F+dy*0.5F*radius1*(float)Math.sin(2D*Math.PI/8D*i), z1+dz*0.5F+dz*radius1*0.5F*(float)Math.cos(2D*Math.PI/8D*i), textureWidth, textureHeight);
	    	        	outervertexes2[i] = new PositionTextureVertex(x2, y1+dy*0.5F+dy*0.5F*radius2*(float)Math.sin(2D*Math.PI/8D*i), z1+dz*0.5F+dz*0.5F*radius2*(float)Math.cos(2D*Math.PI/8D*i), textureWidth, textureHeight);
	    	        	innervertexes2[i] = new PositionTextureVertex(x2, y1+dy*0.5F+dy*0.5F*radius1*radius2*(float)Math.sin(2D*Math.PI/8D*i), z1+dz*0.5F+dz*radius1*radius2*0.5F*(float)Math.cos(2D*Math.PI/8D*i), textureWidth, textureHeight);
	    	        	break;
	        		case WEST:
	    	        	outervertexes1[i] = new PositionTextureVertex(x1, y1+dy*0.5F+dy*0.5F*radius2*(float)Math.sin(2D*Math.PI/8D*i), z1+dz*0.5F+dz*0.5F*radius2*(float)Math.cos(2D*Math.PI/8D*i), textureWidth, textureHeight);
	    	        	innervertexes1[i] = new PositionTextureVertex(x1, y1+dy*0.5F+dy*0.5F*radius2*radius1*(float)Math.sin(2D*Math.PI/8D*i), z1+dz*0.5F+dz*radius1*0.5F*radius2*(float)Math.cos(2D*Math.PI/8D*i), textureWidth, textureHeight);
	    	        	outervertexes2[i] = new PositionTextureVertex(x2, y1+dy*0.5F+dy*0.5F*(float)Math.sin(2D*Math.PI/8D*i), z1+dz*0.5F+dz*0.5F*(float)Math.cos(2D*Math.PI/8D*i), textureWidth, textureHeight);
	    	        	innervertexes2[i] = new PositionTextureVertex(x2, y1+dy*0.5F+dy*0.5F*radius1*(float)Math.sin(2D*Math.PI/8D*i), z1+dz*0.5F+dz*radius1*0.5F*(float)Math.cos(2D*Math.PI/8D*i), textureWidth, textureHeight);
	    	        	break;
	        		default:
	    	        	outervertexes1[i] = new PositionTextureVertex(x1+dx*0.5F+dx*0.5F*(float)Math.cos(2D*Math.PI/8D*i), y1, z1+dz*0.5F+dz*0.5F*(float)Math.sin(2D*Math.PI/8D*i), textureWidth, textureHeight);
	    	        	innervertexes1[i] = new PositionTextureVertex(x1+dx*0.5F+dx*radius1*0.5F*(float)Math.cos(2D*Math.PI/8D*i), y1, z1+dz*0.5F+dz*0.5F*radius1*(float)Math.sin(2D*Math.PI/8D*i), textureWidth, textureHeight);
	    	        	outervertexes2[i] = new PositionTextureVertex(x1+dx*0.5F+dx*0.5F*radius2*(float)Math.cos(2D*Math.PI/8D*i), y2, z1+dz*0.5F+dz*0.5F*radius2*(float)Math.sin(2D*Math.PI/8D*i), textureWidth, textureHeight);
	    	        	innervertexes2[i] = new PositionTextureVertex(x1+dx*0.5F+dx*radius1*radius2*0.5F*(float)Math.cos(2D*Math.PI/8D*i), y2, z1+dz*0.5F+dz*0.5F*radius2*radius1*(float)Math.sin(2D*Math.PI/8D*i), textureWidth, textureHeight);
	    	        	break;
	        	}
	        }
	        for(i=0;i<32;i++)
	        {
	        	if(i<8)
	        	{
	        		this.vertexPositions[i]=outervertexes1[i];
	        	}
	        	else if(i<16)
	        	{
	        		this.vertexPositions[i]=innervertexes1[i-8];
	        	}
	        	else if(i<24)
	        	{
	        		this.vertexPositions[i]=outervertexes2[i-16];
	        	}
	        	else
	        	{
	        		this.vertexPositions[i]=innervertexes2[i-24];
	        	}
	        }
	        
        if(par1ModelRenderer!=null && par1ModelRenderer.drawFromInside)
	    {
	        for(i=0;i<32;i++)
	        {
	        	if(i<7)
	        	{
		        	this.quadList[i]=new TexturedQuad(new PositionTextureVertex[] {outervertexes1[i],innervertexes1[i],innervertexes1[i+1],outervertexes1[i+1]},par2 + par9 + par7, par3 + par9, par2 + par9 + par7 + par9, par3 + par9 + par8, textureWidth, textureHeight);
	        	}
	        	else if(i==7)
	        	{
		        	this.quadList[i]=new TexturedQuad(new PositionTextureVertex[] {outervertexes1[i],innervertexes1[i],innervertexes1[0],outervertexes1[0]},par2 + par9 + par7, par3 + par9, par2 + par9 + par7 + par9, par3 + par9 + par8, textureWidth, textureHeight);
	        	}
	        	else if(i<15)
	        	{
		        	this.quadList[i]=new TexturedQuad(new PositionTextureVertex[] {innervertexes2[i-8],outervertexes2[i-8],outervertexes2[i+1-8],innervertexes2[i+1-8]},par2, par3 + par9, par2 + par9, par3 + par9 + par8, textureWidth, textureHeight);
	        	}
	        	else if(i==15)
	        	{
		        	this.quadList[i]=new TexturedQuad(new PositionTextureVertex[] {innervertexes2[i-8],outervertexes2[i-8],outervertexes2[0],innervertexes2[0]},par2, par3 + par9, par2 + par9, par3 + par9 + par8, textureWidth, textureHeight);
	        	}
	        	else if(i<23)
	        	{
		        	this.quadList[i]=new TexturedQuad(new PositionTextureVertex[] {outervertexes1[i-16],outervertexes1[i-16+1],outervertexes2[i-16+1],outervertexes2[i-16]},par2 + par9, par3, par2 + par9 + par7, par3 + par9, textureWidth, textureHeight);
	        	}
	        	else if(i==23)
	        	{
		        	this.quadList[i]=new TexturedQuad(new PositionTextureVertex[] {outervertexes1[i-16],outervertexes1[0],outervertexes2[0],outervertexes2[i-16]},par2 + par9, par3, par2 + par9 + par7, par3 + par9, textureWidth, textureHeight);
	        	}
	        	else if(i<31)
	        	{
		        	this.quadList[i]=new TexturedQuad(new PositionTextureVertex[] {innervertexes1[i-24+1],innervertexes1[i-24],innervertexes2[i-24],innervertexes2[i-24+1]},par2 + par9, par3, par2 + par9 + par7, par3 + par9, textureWidth, textureHeight);
	        	}
	        	else if(i==31)
	        	{
		        	this.quadList[i]=new TexturedQuad(new PositionTextureVertex[] {innervertexes1[0],innervertexes1[i-24],innervertexes2[i-24],innervertexes2[0]},par2 + par9, par3, par2 + par9 + par7, par3 + par9, textureWidth, textureHeight);
	        	}
	        }
	    }
        else
	    {
	        for(i=0;i<32;i++)
	        {
	        	if(i<7)
	        	{
		        	this.quadList[i]=new TexturedQuad(new PositionTextureVertex[] {outervertexes1[i],outervertexes1[i+1],innervertexes1[i+1],innervertexes1[i]},par2 + par9 + par7, par3 + par9, par2 + par9 + par7 + par9, par3 + par9 + par8, textureWidth, textureHeight);
	        	}
	        	else if(i==7)
	        	{
		        	this.quadList[i]=new TexturedQuad(new PositionTextureVertex[] {outervertexes1[i],outervertexes1[0],innervertexes1[0],innervertexes1[i]},par2 + par9 + par7, par3 + par9, par2 + par9 + par7 + par9, par3 + par9 + par8, textureWidth, textureHeight);
	        	}
	        	else if(i<15)
	        	{
		        	//this.quadList[i]=new TexturedQuad(new PositionTextureVertex[] {outervertexes2[i-8],outervertexes2[i+1-8],innervertexes2[i+1-8],innervertexes2[i-8]},par2, par3 + par9, par2 + par9, par3 + par9 + par8, textureWidth, textureHeight);
		        	this.quadList[i]=new TexturedQuad(new PositionTextureVertex[] {innervertexes2[i-8],innervertexes2[i+1-8],outervertexes2[i+1-8],outervertexes2[i-8]},par2, par3 + par9, par2 + par9, par3 + par9 + par8, textureWidth, textureHeight);
	        	}
	        	else if(i==15)
	        	{
		        	//this.quadList[i]=new TexturedQuad(new PositionTextureVertex[] {outervertexes2[i-8],outervertexes2[0],innervertexes2[0],innervertexes2[i-8]},par2, par3 + par9, par2 + par9, par3 + par9 + par8, textureWidth, textureHeight);
		        	this.quadList[i]=new TexturedQuad(new PositionTextureVertex[] {innervertexes2[i-8],innervertexes2[0],outervertexes2[0],outervertexes2[i-8]},par2, par3 + par9, par2 + par9, par3 + par9 + par8, textureWidth, textureHeight);
	        	}
	        	else if(i<23)
	        	{
		        	this.quadList[i]=new TexturedQuad(new PositionTextureVertex[] {outervertexes1[i-16],outervertexes2[i-16],outervertexes2[i-16+1],outervertexes1[i-16+1]},par2 + par9, par3, par2 + par9 + par7, par3 + par9, textureWidth, textureHeight);
	        	}
	        	else if(i==23)
	        	{
		        	this.quadList[i]=new TexturedQuad(new PositionTextureVertex[] {outervertexes1[i-16],outervertexes2[i-16],outervertexes2[0],outervertexes1[0]},par2 + par9, par3, par2 + par9 + par7, par3 + par9, textureWidth, textureHeight);
	        	}
	        	else if(i<31)
	        	{
		        	//this.quadList[i]=new TexturedQuad(new PositionTextureVertex[] {innervertexes1[i-24],innervertexes2[i-24],innervertexes2[i-24+1],innervertexes1[i-24+1]},par2 + par9, par3, par2 + par9 + par7, par3 + par9, textureWidth, textureHeight);
		        	this.quadList[i]=new TexturedQuad(new PositionTextureVertex[] {innervertexes1[i-24+1],innervertexes2[i-24+1], innervertexes2[i-24], innervertexes1[i-24]},par2 + par9, par3, par2 + par9 + par7, par3 + par9, textureWidth, textureHeight);
	        	}
	        	else if(i==31)
	        	{
	        		//this.quadList[i]=new TexturedQuad(new PositionTextureVertex[] {innervertexes1[i-24],innervertexes2[i-24],innervertexes2[0],innervertexes1[0]},par2 + par9, par3, par2 + par9 + par7, par3 + par9, textureWidth, textureHeight);
		        	this.quadList[i]=new TexturedQuad(new PositionTextureVertex[] {innervertexes1[0],innervertexes2[0],innervertexes2[i-24],innervertexes1[i-24]},par2 + par9, par3, par2 + par9 + par7, par3 + par9, textureWidth, textureHeight);
	        	}
	        }
	    }
	        if (par1ModelRenderer!=null && par1ModelRenderer.mirror)
	        {
	            for (int var22 = 0; var22 < this.quadList.length; ++var22)
	            {
	                this.quadList[var22].flipFace();
	            }
	        }
	    }

	    public void render(Tessellator par1Tessellator, float par2)
	    {
	    	for(int i=0;i<this.quadList.length;i++)
	    	{
    			this.quadList[i].draw(par1Tessellator, par2);
	    	}
	    }
	    
	    public void renderCached(Tessellator par1Tessellator, float par2)
	    {
			if (this.displayListCache != -1)
			{
				GL11.glCallList(displayListCache);
			}
			else
			{
				this.displayListCache=GLAllocation.generateDisplayLists(1);
		       	GL11.glNewList(displayListCache, 4864 /*GL_COMPILE*/);
		    	for(int i=/*16*/0;i<=23;i++)
		    	{
	    			this.quadList[i].draw(par1Tessellator, par2);
		    	}
		       	GL11.glEndList();
			}
	    }

	    public ModelTube func_78244_a(String par1Str)
	    {
	        this.field_78247_g = par1Str;
	        return this;
	    }
}
