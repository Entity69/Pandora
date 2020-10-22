// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelbluepeepss extends EntityModel<Entity> {
	private final ModelRenderer bipedHead;
	private final ModelRenderer bipedBody;
	private final ModelRenderer bipedRightArm;
	private final ModelRenderer bipedLeftArm;
	private final ModelRenderer bipedRightLeg;
	private final ModelRenderer bipedLeftLeg;
	private final ModelRenderer bipedChest;

	public Modelbluepeepss() {
		textureWidth = 64;
		textureHeight = 64;

		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, -7.0F, 0.0F);
		bipedHead.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(0.0F, -7.0F, 0.0F);
		bipedBody.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 15.0F, 4.0F, 0.0F, false);

		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-5.0F, -6.0F, 0.0F);
		bipedRightArm.setTextureOffset(40, 16).addBox(-3.0F, -1.0F, -2.0F, 4.0F, 19.0F, 4.0F, 0.0F, false);

		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(5.0F, -6.0F, 0.0F);
		bipedLeftArm.setTextureOffset(32, 41).addBox(-1.0F, -1.0F, -2.0F, 4.0F, 19.0F, 4.0F, 0.0F, false);

		bipedRightLeg = new ModelRenderer(this);
		bipedRightLeg.setRotationPoint(-1.9F, 8.0F, 0.0F);
		bipedRightLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 16.0F, 4.0F, 0.0F, false);

		bipedLeftLeg = new ModelRenderer(this);
		bipedLeftLeg.setRotationPoint(1.9F, 8.0F, 0.0F);
		bipedLeftLeg.setTextureOffset(16, 44).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 16.0F, 4.0F, 0.0F, false);

		bipedChest = new ModelRenderer(this);
		bipedChest.setRotationPoint(0.0F, -3.75F, -2.5F);
		setRotationAngle(bipedChest, -0.3054F, 0.0F, 0.0F);
		bipedChest.setTextureOffset(0, 36).addBox(-3.5F, -1.5F, 0.0F, 7.0F, 4.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bipedHead.render(matrixStack, buffer, packedLight, packedOverlay);
		bipedBody.render(matrixStack, buffer, packedLight, packedOverlay);
		bipedRightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		bipedLeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		bipedRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		bipedLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		bipedChest.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.bipedRightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.bipedRightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.bipedLeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.bipedHead.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.bipedHead.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}