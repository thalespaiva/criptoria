#!/usr/bin/python

DEFAULT_KEY_BYTE_SIZE = 16


def gen_main_key_from_user_key(user_key, key_byte_size=DEFAULT_KEY_BYTE_SIZE):
    factor = key_byte_size // len(user_key)
    main_key = (factor + 1) * user_key

    return main_key[:key_byte_size]

if __name__ == "__main__":
    import sys

    if len(sys.argv) != 2:
        print("[-] Usage: ", sys.argv[0], "<key>")
        sys.exit(1)

    user_key = sys.argv[1]
    main_key = gen_main_key_from_user_key(user_key)

    print('[+] main_key : ', main_key)
