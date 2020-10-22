// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelhammerhead extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer leg4;
	private final ModelRenderer leg3;
	private final ModelRenderer leg5;
	private final ModelRenderer leg6;
	private final ModelRenderer leg31;
	private final ModelRenderer leg2;
	private final ModelRenderer head;

	public Modelhammerhead() {
		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(-28, 54).addBox(-13.0F, -44.0F, -22.0F, 26.0F, 22.0F, 52.0F, 4.0F, false);
		body.setTextureOffset(69, 29).addBox(-7.0F, -47.0F, -19.0F, 14.0F, -8.0F, 15.0F, 7.0F, false);
		body.setTextureOffset(76, 75).addBox(0.0F, -61.0F, -18.0F, 0.0F, 5.0F, 23.0F, 3.0F, false);
		body.setTextureOffset(31, 77).addBox(-1.5F, -44.0F, 33.0F, 3.0F, 8.0F, 4.0F, 0.0F, false);

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(-16.0F, -27.0F, -1.0F);
		body.addChild(leg4);
		leg4.setTextureOffset(91, 77).addBox(0.0F, -1.0F, 1.0F, -6.0F, 2.0F, -1.0F, 7.0F, false);
		leg4.setTextureOffset(78, 77).addBox(-3.0F, 11.0F, -1.0F, 0.0F, 13.0F, 3.0F, 3.0F, false);

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(-16.0F, -27.0F, -16.0F);
		body.addChild(leg3);
		leg3.setTextureOffset(91, 77).addBox(0.0F, -1.0F, 1.0F, -6.0F, 2.0F, -1.0F, 7.0F, false);
		leg3.setTextureOffset(78, 77).addBox(-3.0F, 11.0F, -1.0F, 0.0F, 13.0F, 3.0F, 3.0F, false);

		leg5 = new ModelRenderer(this);
		leg5.setRotationPoint(16.0F, -27.0F, -1.0F);
		body.addChild(leg5);
		leg5.setTextureOffset(91, 77).addBox(6.0F, -1.0F, 1.0F, -6.0F, 2.0F, -1.0F, 7.0F, false);
		leg5.setTextureOffset(78, 77).addBox(3.0F, 11.0F, -1.0F, 0.0F, 13.0F, 3.0F, 3.0F, false);

		leg6 = new ModelRenderer(this);
		leg6.setRotationPoint(16.0F, -27.0F, -16.0F);
		body.addChild(leg6);
		leg6.setTextureOffset(91, 77).addBox(6.0F, -1.0F, 1.0F, -6.0F, 2.0F, -1.0F, 7.0F, false);
		leg6.setTextureOffset(78, 77).addBox(3.0F, 11.0F, -1.0F, 0.0F, 13.0F, 3.0F, 3.0F, false);

		leg31 = new ModelRenderer(this);
		leg31.setRotationPoint(16.0F, -5.0F, 23.0F);
		leg31.setTextureOffset(123, 0).addBox(6.0F, -1.0F, 0.0F, -6.0F, 2.0F, 1.0F, 7.0F, false);
		leg31.setTextureOffset(121, 0).addBox(4.0F, 13.0F, -1.0F, -2.0F, 11.0F, 3.0F, 5.0F, false);

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(-16.0F, -5.0F, 23.0F);
		leg2.setTextureOffset(123, 0).addBox(0.0F, -1.0F, 0.0F, -6.0F, 2.0F, 1.0F, 7.0F, false);
		leg2.setTextureOffset(121, 0).addBox(-2.0F, 13.0F, -1.0F, -2.0F, 11.0F, 3.0F, 5.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(-1.0F, -13.0F, -24.0F);
		setRotationAngle(head, 0.1309F, 0.0F, 0.0F);
		head.setTextureOffset(15, 29).addBox(-4.0F, -5.0F, -23.0F, 10.0F, 10.0F, 15.0F, 6.0F, false);
		head.setTextureOffset(15, 19).addBox(-20.0F, -7.5513F, -34.4395F, 43.0F, 1.0F, 1.0F, 5.0F, false);
		head.setTextureOffset(15, 0).addBox(-7.0F, 11.861F, -24.8917F, 16.0F, 1.0F, 6.0F, 1.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		leg31.render(matrixStack, buffer, packedLight, packedOverlay);
		leg2.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.leg4.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg5.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg3.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg6.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leg31.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}