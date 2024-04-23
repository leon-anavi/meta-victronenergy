SUMMARY = "A full modbus protocol written in python."
HOMEPAGE = "https://github.com/riptideio/pymodbus"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c2223d66c7e674b40527b5a4c35bd76"

SRC_URI = "git://github.com/riptideio/pymodbus.git;branch=master;protocol=http;tag=v${PV}"
SRC_URI[sha256sum] = "398a3db6d61899d25fd4a06c6ca12051b0ce171d705decd7ed5511517b4bb93d"

S = "${WORKDIR}/git"

inherit setuptools3

RDEPENDS:${PN} = "python3-pyserial python3-six"
