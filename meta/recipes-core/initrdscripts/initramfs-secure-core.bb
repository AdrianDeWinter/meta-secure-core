SUMMARY = "Basic init for initramfs to mount and pivot root"
LICENSE = "MIT"

SRC_URI = "file://init"

do_install() {
        install -m 0755 "${WORKDIR}/init" "${D}/init"

        # Create device nodes expected by kernel in initramfs
        # before executing /init.
        install -d "${D}/dev"
        mknod -m 0600 "${D}/dev/console" c 5 1
}

FILES_${PN} = "/init /dev"

RDEPENDS_${PN} = "\
    bash \
    kmod \
    sed \
    grep \
    coreutils \
    util-linux \
    gawk \
    mdadm \
    udev \
"