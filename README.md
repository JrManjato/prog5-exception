# Exception Simulator in Java

This project is a Java application designed to simulate various common errors encountered during file exchanges. The goal is to provide a testing environment for error management in an application dealing with files. In this case, we have chosen images as a case study.

## Simulated Exceptions

### 1. `SensitiveFileException`

This exception is thrown when an attempt is made to download or process a file containing sensitive information. For example, a file that should not be shared due to its confidential content.

### 2. `NotAuthorizedException`

This exception is generated when access to a specific directory is denied. This can simulate a situation where a user tries to access a folder for which they do not have the necessary permissions.

### 3. `BadFileTypeException`

This exception is thrown when a file of an unauthorized type is submitted. For example, if the application expects an image and receives a text file, this exception will be generated.

### 4. `FileNameInvalidException`

This exception indicates that a file is rejected due to an invalid filename. The application may apply specific rules regarding allowed filenames.

### 5. `DuplicateFileException`

When a user tries to download a file that already exists, this exception is thrown to signal a conflict with an existing file.

### 6. `LargeFileException`

This exception is generated when the size of a file exceeds a predefined limit. This could simulate a restriction on the size of downloadable files.

### 7. `NotFoundException`

When a request is made to obtain a file that does not exist, this exception is thrown. It indicates that the requested file was not found.

## Usage

To test these exceptions, submit requests to the application with conditions that trigger the corresponding errors. For example, try to download a file with an invalid name or attempt to access an unauthorized directory.

## Contributing

If you want to contribute to this project, please refer to the guidelines in the [CONTRIBUTING.md](CONTRIBUTING.md) file.

## License

This project is licensed under the [MIT License](LICENSE.md).
