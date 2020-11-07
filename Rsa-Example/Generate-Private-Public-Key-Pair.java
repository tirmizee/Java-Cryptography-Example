public class RSA {

  public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
    // Generating a Key Pair
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
	
		keyPairGenerator.initialize(2048);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		
		PrivateKey privateKey = keyPair.getPrivate();
		PublicKey publicKey = keyPair.getPublic();
  
  }
  
}
