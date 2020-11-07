
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

#### Saving the Keys in Binary Format

	String file = "D:\\Generate RSA\\private.key";
	FileOutputStream outFilePrivateKey = new FileOutputStream(file);
	outFilePrivateKey.write(privateKey.getEncoded());
	outFilePrivateKey.close();

	String file = "D:\\Generate RSA\\public.key";
	FileOutputStream outFilePublicKey = new FileOutputStream(file);
	outFilePublicKey.write(publicKey.getEncoded());
	outFilePublicKey.close();

#### Checking the Keys format

	System.err.println(privateKey.getFormat()); // PKCS#8
	System.err.println(publicKey.getFormat());  // X.509

### Reference

- https://www.novixys.com/blog/how-to-generate-rsa-keys-java/
