#Changes Made in domain

Changed all the domain entities to use project lombok 
for better readability and maintainability

Used @Value and @NoArgsConstructor(force = true, access = AccessLevel.PRIVATE) @AllArgsConstructor
for entity immutability and support for Jackson serialization deserialization

added junit5 for testing purposes but not used it at full
added gson for json support in mock rest controller test