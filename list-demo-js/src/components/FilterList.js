import React from 'react'

class FilterList extends React.Component {
    state = {
        filter: ''
    };

    onChange = (e) => {
        this.setState( {filter: e.target.value});
        this.props.filterList(this.state.filter);
    };

    render() {
        return (
            <div>
                <form style={{ display: 'flex' }}>
                    <input type="text" name="category" placeholder="filter category..." style={{flex: '10'}}
                           value={this.state.filter} onChange={this.onChange} className="filterInput"/>
                </form>
            </div>
            )
    }
}

export default FilterList;