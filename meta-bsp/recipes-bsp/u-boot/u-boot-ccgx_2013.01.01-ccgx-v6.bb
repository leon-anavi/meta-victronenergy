require u-boot.inc

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"
SRC_URI += "https://github.com/victronenergy/u-boot/archive/v${PV}.tar.gz"
SRC_URI[sha256sum] = "4c4e1158909be0a2b01f8f8c06eedecd1a3be10cd7279c5a73f87859b6ce7c62"
S = "${WORKDIR}/u-boot-${PV}"

DEPENDS += "u-boot-mkimage-native"

COMPATIBLE_MACHINE = "ccgx"

SRC_URI += " \
    file://install.cmds \
    file://live.cmds \
    file://splash.bgra \
"

do_compile:append () {
    mkimage -A arm -T script -C none -n 'Install Script' -d ${WORKDIR}/install.cmds ${WORKDIR}/install.scr
    mkimage -A arm -T script -C none -n 'Live Script' -d ${WORKDIR}/live.cmds ${WORKDIR}/live.scr
}

do_deploy:append () {
    install -d ${DEPLOYDIR}
    install -m 0644 ${WORKDIR}/install.scr ${DEPLOYDIR}/install.scr
    install ${WORKDIR}/live.scr ${DEPLOYDIR}
    install ${WORKDIR}/splash.bgra ${DEPLOYDIR}
}
