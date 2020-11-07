
#### Public key cryptography can be used in two modes

- <b>Encryption:</b> Only the private key can decrypt the data encrypted with the public key.
- <b>Authentication:</b> Data encrypted with the private key can only be decrypted with the public key thus proving who the data came from.

#### Generating a Key Pair

    	KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
	
	keyPairGenerator.initialize(2048);
	KeyPair keyPair = keyPairGenerator.generateKeyPair();

	PrivateKey privateKey = keyPair.getPrivate();
	PublicKey publicKey = keyPair.getPublic();

### Reference

- https://www.novixys.com/blog/how-to-generate-rsa-keys-java/
