# ShowMyIP

<div align="center">
  <img src="src/main/resources/META-INF/pluginIcon.png" alt="ShowMyIP Plugin Icon" width="128" height="128">
</div>

[![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF)](https://kotlinlang.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![JetBrains Plugins](https://img.shields.io/badge/JetBrains-Plugins-blue)](https://plugins.jetbrains.com/plugin/ShowMyIP)

An IntelliJ IDEA plugin that displays your local LAN IP address directly in the IDE status bar.

## Features

- Shows your local network IP address in the status bar
- Click on the IP address to refresh and get the latest IP
- Lightweight and non-intrusive
- Works with all IntelliJ-based IDEs

## Installation

### From JetBrains Marketplace

1. Open IntelliJ IDEA
2. Go to `Settings` → `Plugins`
3. Search for "ShowMyIP"
4. Click `Install` and restart your IDE

### Manual Installation

1. Download the plugin JAR from the [Releases](https://github.com/yourusername/ShowMyIP/releases) page
2. Open IntelliJ IDEA
3. Go to `Settings` → `Plugins` → `Install Plugin from Disk`
4. Select the downloaded JAR file and click `OK`
5. Restart your IDE

## Usage

Once installed, the plugin will automatically display your local IP address in the status bar at the bottom of your IDE window.

- **View IP**: The IP address will be shown in the status bar (e.g., "192.168.1.100")
- **Refresh**: Click on the IP address text to refresh and get the current IP address
- **Network Changes**: The IP will automatically update when your network connection changes

## Development

### Prerequisites

- JDK 11 or higher
- IntelliJ IDEA 2022.2 or higher

### Building from Source

1. Clone this repository:
   ```bash
   git clone https://github.com/anup690/ShowMyIP.git
   cd ShowMyIP
   ```

2. Open the project in IntelliJ IDEA

3. Run the plugin:
   - Use the predefined "Run Plugin" configuration
   - Or run `./gradlew runIde` from the terminal

4. Build the plugin:
   ```bash
   ./gradlew buildPlugin
   ```

5. The plugin JAR will be created in `build/libs/`

### Testing

Run tests with:
```bash
./gradlew test
```

### Publishing

To publish to JetBrains Marketplace:
```bash
./gradlew publishPlugin
```

Make sure to configure your JetBrains Hub credentials in `gradle.properties`.

## Project Structure

```
.
├── src/main/kotlin/           # Kotlin source code
├── src/main/resources/        # Plugin resources and configuration
│   └── META-INF/plugin.xml    # Plugin manifest
├── build.gradle.kts           # Gradle build configuration
├── gradle.properties          # Gradle properties
└── README.md                  # This file
```

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Support

If you find this plugin useful, please consider starring the repository on GitHub!

## Acknowledgments

- Built with the [IntelliJ Platform SDK](https://plugins.jetbrains.com/docs/intellij/intellij-platform.html)
- Uses [IntelliJ Platform Gradle Plugin](https://github.com/JetBrains/intellij-platform-gradle-plugin)
