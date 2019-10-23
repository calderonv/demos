import React from 'react'

function ListAppHeader() {

    return (
        <header style={headerStyle}>
            <h1>Jeopardy Categories</h1>
        </header>
    )
}

const headerStyle = {
    backgroundColor: '#015EFE',
    color: '#FFFFFF',
    padding: '15px'
};

export default ListAppHeader;