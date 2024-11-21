require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc
require u-boot-sunxi.inc

PROVIDES = ""
SRC_URI += "file://fw_env.config"

do_compile () {
    oe_runmake -C ${S} ${UBOOT_MACHINE}
    oe_runmake -C ${S} CC="${CC} ${CFLAGS} ${LDFLAGS}" STRIP="echo" envtools
}

do_install () {
    install -d ${D}/${base_sbindir}
    install ${S}/tools/env/fw_printenv ${D}/${base_sbindir}
    ln -sf fw_printenv ${D}${base_sbindir}/fw_setenv

    install -d ${D}${libdir}
    install -m 644 ${S}/tools/env/lib.a ${D}${libdir}/libubootenv.a

    install -d ${D}${sysconfdir}
    install -m 644 ${UNPACKDIR}/fw_env.config ${D}${sysconfdir}
}

do_deploy[noexec] = "1"

FILES:${PN} = "${base_sbindir} ${datadir} ${libdir} ${sysconfdir}"
