# Hash Converter CLI Application
Java program that converts a user-provided word to a hash value using various hashing algorithms. The program supports MD5, SHA-1, and SHA-256 hashing algorithms. The generated hash values are saved to a text file for later reference.

![hashConvert-preview](/hashConvert-preview.png)

## Features
- **Input Validation**: Ensures the word does not contain numbers, spaces, or non-English characters.
- **Multiple Hash Algorithms**: Supports MD5, SHA-1, and SHA-256.
- **File Output**: Saves the generated hashes to a uniquely named text file.
- **Interactive Console**: User-friendly console interface for input and interaction

## How It's Made:

**Tech used:** Java

Leverages Java's core libraries to create an interactive command-line interface (CLI) application using Java's features and libraries like:
- User Input Handling
- File Operations
- Random Number Generation
- Hashing Algorithms
- Control Flow and User Interaction
- ANSI Escape Codes

## How to Use:

1. Clone the repository:
```
git clone [https://github.com/contactkc/calorie-counter.git](https://github.com/contactkc/cli-hashConvert.git)
```
2. Navigate to the project directory:
```
cd cli-hashConvert/src
```
3. Compile the Program 
```
javac hashConvert.java
```
4. Run the Program:
```
java hashConvert
```

## License
This project is [MIT licensed](LICENSE).
