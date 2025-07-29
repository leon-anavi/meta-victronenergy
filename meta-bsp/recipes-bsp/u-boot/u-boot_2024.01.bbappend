# Use U-Boot 2025.04 that supports Raspberry Pi 5
# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV:raspberrypi5 = "cddbaf61aa41c5bc4ea0d9aa06a093434cf4b9d9"

SRC_URI:raspberrypi5 = "git://github.com/leon-anavi/u-boot;protocol=https;branch=victron/2025.04"

DEPENDS += "gnutls-native"
