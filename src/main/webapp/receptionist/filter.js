const roomInput = document.getElementById("room")
const floorInput = document.getElementById("floor")
const priceInput = document.getElementById("price")
const typeInput = document.getElementById("type")
const tbody=document.getElementById("tbody");

const template = (room, floor,price,type) => {
    return `<tr><td>${room}</td><td>${floor}</td><td>${price}</td><td>${type}</td><td><form action="../common/bookARoom.jsp" method="post"><button name="1234" value="${room}">BOOK</button></form></td><td><form action="deleteRoom.jsp" method="post"><button style="background-color:#F93C30;" name="del" value="${room}">DELETE</button></form></td><td><form action="updateRoom.jsp"><button style="background-color:#4AE0EA;" name="update" value="${room}">UPDATE</button></form></td></tr>`;
}

const query = async () => {
    let room = roomInput.value;
    let floor=floorInput.value;
    let price = priceInput.value;
    let type = typeInput.value;

    if (room === undefined || room.trim() === "") room = null;
    else room = Number(room);

    if (floor === undefined || floor.trim() === "") floor = null;
    else floor = Number(floor);

    if (price === undefined || price.trim() === "") price = null;
    else price = Number(price);

    if (type === undefined || type.trim() === "") type = null;

    const url = new URL("apiFilter.jsp",window.location.href);

    url.searchParams.append("room",room);
    url.searchParams.append("floor",floor);
    url.searchParams.append("price",price);
    url.searchParams.append("type",type);
    try {
        const response= await (await fetch(url)).json();

        tbody.innerHTML = "";
        for (let item of response) {
            tbody.innerHTML+= template(item['ava_room_id'], item['floor'], item['price'], item['type'])
        }
    } catch(e){
console.error(e)
    }
}

roomInput.addEventListener("change", e => {
    query()
});
floorInput.addEventListener("change", e => {
    query()
});
priceInput.addEventListener("change", e => {
    query()
});
typeInput.addEventListener("change", e => {
    query()
});