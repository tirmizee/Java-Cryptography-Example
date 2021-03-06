
#### Public key cryptography can be used in two modes 

- <b>Encryption:</b> Only the private key can decrypt the data encrypted with the public key.
- <b>Authentication:</b> Data encrypted with the private key can only be decrypted with the public key thus proving who the data came from.

#### Generating a Key Pair

	KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA"); //Algorithm 
	
	keyPairGenerator.initialize(2048); //RS256
	keyPairGenerator.initialize(3072); //RS384
	keyPairGenerator.initialize(4096); //RS512

	KeyPair keyPair = keyPairGenerator.generateKeyPair();   //Key Pair
	PrivateKey privateKey = keyPair.getPrivate();           //Private Key
	PublicKey publicKey = keyPair.getPublic();              //Public Key

#### Checking the Keys format

	System.err.println(privateKey.getFormat()); // PKCS#8
	System.err.println(publicKey.getFormat());  // X.509

#### Saving the Keys in Binary Format

	String file = "D:\\Generate RSA\\private.key";
	FileOutputStream outFilePrivateKey = new FileOutputStream(file);
	outFilePrivateKey.write(privateKey.getEncoded());
	outFilePrivateKey.close();

	String file = "D:\\Generate RSA\\public.key";
	FileOutputStream outFilePublicKey = new FileOutputStream(file);
	outFilePublicKey.write(publicKey.getEncoded());
	outFilePublicKey.close();

#### Saving the Keys in Text Format

	String outFile = "D:\\Generate RSA\\private.key";
	Writer out = new FileWriter(outFile);
	out.write("-----BEGIN RSA PRIVATE KEY-----\n");
	out.write(encoder.encodeToString(privateKey.getEncoded()));
	out.write("\n-----END RSA PRIVATE KEY-----\n");
	out.close();

	String outFile = "D:\\Generate RSA\\public.key";
	Writer out = new FileWriter(outFile + "public.key");
	out.write("-----BEGIN RSA PUBLIC KEY-----\n");
	out.write(encoder.encodeToString(publicKey.getEncoded()));
	out.write("\n-----END RSA PUBLIC KEY-----\n");
	out.close();

#### Load Private Key from File

	String keyFile = "D:\\Generate RSA\\private.key";
	Path path = Paths.get(keyFile);
	byte[] bytes = Files.readAllBytes(path);

	PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
	KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
	System.out.println(privateKey.getAlgorithm() + privateKey.getFormat()); //RSA PKCS#8


#### Load Public Key from File

	String keyFile = "D:\\Generate RSA\\public.key";
	Path path = Paths.get(keyFile);
	byte[] bytes = Files.readAllBytes(path);

	X509EncodedKeySpec keySpec = new X509EncodedKeySpec(bytes);
	KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	PublicKey publicKey = keyFactory.generatePublic(keySpec);
	System.out.println(publicKey.getAlgorithm() + publicKey.getFormat()); //RSA X.509

### Reference

- https://www.novixys.com/blog/how-to-generate-rsa-keys-java/
