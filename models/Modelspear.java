// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelspear extends EntityModel<Entity> {
	private final ModelRenderer mainBody;
	private final ModelRenderer pole;
	private final ModelRenderer top1;
	private final ModelRenderer top2;
	private final ModelRenderer top3;
	private final ModelRenderer top4;

	public Modelspear() {
		textureWidth = 32;
		textureHeight = 32;

		mainBody = new ModelRenderer(this);
		mainBody.setRotationPoint(0.0F, 24.0F, 0.0F);

		pole = new ModelRenderer(this);
		pole.setRotationPoint(0.0F, 0.0F, 0.0F);
		pole.setTextureOffset(0, 0).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 31.0F, 1.0F, 0.01F, true);

		top1 = new ModelRenderer(this);
		top1.setRotationPoint(0.25F, -3.75F, 0.0F);
		pole.addChild(top1);
		setRotationAngle(top1, 0.2618F, 0.0F, 0.0F);
		top1.setTextureOffset(0, 0).addBox(-0.75F, -0.5F, -0.25F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		top2 = new ModelRenderer(this);
		top2.setRotationPoint(-0.25F, -3.5F, 0.0F);
		pole.addChild(top2);
		setRotationAngle(top2, 0.0F, 0.0F, 0.2618F);
		top2.setTextureOffset(0, 0).addBox(-0.5F, -0.75F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		top3 = new ModelRenderer(this);
		top3.setRotationPoint(0.25F, -3.25F, 0.0F);
		pole.addChild(top3);
		setRotationAngle(top3, 0.0F, 0.0F, -0.2618F);
		top3.setTextureOffset(0, 0).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		top4 = new ModelRenderer(this);
		top4.setRotationPoint(0.0F, -3.75F, -0.25F);
		pole.addChild(top4);
		setRotationAngle(top4, -0.2618F, 0.0F, 0.0F);
		top4.setTextureOffset(0, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		mainBody.render(matrixStack, buffer, packedLight, packedOverlay);
		pole.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}