#!/bin/sh

if [ ! -d /data/keys ]; then
	mkdir /data/keys
	# note: flashmq needs directory access as well
	chmod 755 /data/keys
else
	rm -f /data/keys/ssh_host_dsa_key
	rm -f /data/keys/ssh_host_dsa_key.pub
fi

check_key() (
	key=$1

	a=$(ssh-keygen -y -f $key 2>/dev/null | cut -d ' ' -f -2) || return
	b=$(cut -d ' ' -f -2 $key.pub 2>/dev/null) || return

	test -n "$a" -a "$a" = "$b"
)

gen_key() {
	type=$1
	key=/data/keys/ssh_host_${type}_key

	check_key $key && return

	echo "  generating ssh ${type} key..."
	rm -f $key $key.pub
	ssh-keygen -q -f $key -N '' -t $type
}

echo "*** Create keys if necessary..."
gen_key rsa
gen_key ecdsa

echo "*** Create the PrivSep empty dir if necessary..."
if [ ! -d /var/run/sshd ]; then
	mkdir /var/run/sshd
	chmod 0755 /var/run/sshd
fi

echo "*** Starting sshd..."
exec /usr/sbin/sshd -D -e -f /etc/ssh/sshd_config -h /data/keys/ssh_host_rsa_key -h /data/keys/ssh_host_ecdsa_key
