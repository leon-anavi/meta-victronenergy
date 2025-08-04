DESCRIPTION = "A plugin that turns FlashMQ into a dbus aware MQTT broker."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a5815abd99fd5defcd36000125b24f99"
DEPENDS = "dbus"

inherit cmake pkgconfig

UPSTREAM_CHECK_GITTAGREGEX = "v(?P<pver>\S+)"
SRC_URI = "git://github.com/victronenergy/dbus-flashmq.git;branch=master;protocol=https"
SRCREV = "067dd6a074c3484ceea35a13666f2d9a69d81346"
S = "${WORKDIR}/git"
EXTRA_OECMAKE = "-DCMAKE_BUILD_TYPE=Release"

PACKAGES =+ "${PN}-test"

FILES:${PN}-test = "${bindir}/flashmq-dbus-plugin-tests"
