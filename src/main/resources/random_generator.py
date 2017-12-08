import os, random, string, json


class Post:
    def __init__(self, title="", content=""):
        self.title = title
        self.message = content


def open_file(path=""):
    basedir = os.path.dirname(path)
    if not os.path.exists(basedir):
        os.makedirs(basedir)
    return open(path, "w+")


def generate_random_string(length):
    letters = string.ascii_letters
    return ''.join(random.choice(letters) for i in range(length))


def generate_random_post():
    return Post(generate_random_string(random.randint(5, 20)), generate_random_string(random.randint(50, 200)))


def generate_random_list(count=10):
    random_list = []
    for i in range(count):
        post = generate_random_post()
        random_list.append(post.__dict__)
    return random_list


def generate_random(path="./output", count=1, format_file="json"):
    with open_file(path) as file:
        rl = generate_random_list(count)
        json.dump(rl, file, indent=2)


def main():
    path = input("Введите путь к файлу: ")
    count = int(input("Введите количество: "))
    format_file = input("Введите формат: ")
    generate_random(path, count, format_file)


if __name__ == "__main__":
    main()
