FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
	file://0001-fw_env-use-default-environment-if-open-failed.patch \
	file://0001-rpi-config-update-default-configuration-for-rpi5.patch \
	file://0001-rpi.env-simplify-booting-and-add-dual-rootfs.patch \
	file://0004-build-libubootenv-for-older-swupdate.patch \
"
